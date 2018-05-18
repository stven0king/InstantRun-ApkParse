package com.android.tools.ir.server;

import android.app.Activity;
import android.content.Context;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.tools.ir.common.ProtocolConstants;
import com.android.tools.ir.runtime.ApplicationPatch;
import com.android.tools.ir.runtime.PatchesLoader;
import com.android.tools.ir.runtime.Paths;
import dalvik.system.DexClassLoader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Server {
    private static final boolean POST_ALIVE_STATUS = false;
    private static final boolean RESTART_LOCALLY = false;
    private static int wrongTokenCount;
    private final Context context;
    private LocalServerSocket serverSocket;

    private class SocketServerReplyThread extends Thread {
        private final LocalSocket socket;

        SocketServerReplyThread(LocalSocket socket) {
            this.socket = socket;
        }

        public void run() {
            DataInputStream input;
            DataOutputStream output;
            try {
                input = new DataInputStream(this.socket.getInputStream());
                output = new DataOutputStream(this.socket.getOutputStream());
                handle(input, output);
                try {
                    input.close();
                } catch (IOException e) {
                }
                try {
                    output.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Fatal error receiving messages", e3);
                }
            } catch (Throwable th) {
                try {
                    input.close();
                } catch (IOException e4) {
                }
                try {
                    output.close();
                } catch (IOException e5) {
                }
            }
        }

        private void handle(DataInputStream input, DataOutputStream output) throws IOException {
            long magic = input.readLong();
            if (magic != ProtocolConstants.PROTOCOL_IDENTIFIER) {
                Log.w(Logging.LOG_TAG, "Unrecognized header format " + Long.toHexString(magic));
                return;
            }
            int version = input.readInt();
            output.writeInt(4);
            if (version != 4) {
                Log.w(Logging.LOG_TAG, "Mismatched protocol versions; app is using version 4 and tool is using version " + version);
                return;
            }
            while (true) {
                int message = input.readInt();
                switch (message) {
                    case 1:
                        if (authenticate(input)) {
                            List<ApplicationPatch> changes = ApplicationPatch.read(input);
                            if (changes == null) {
                                break;
                            }
                            boolean hasResources = Server.hasResources(changes);
                            int updateMode = Server.this.handlePatches(changes, hasResources, input.readInt());
                            boolean showToast = input.readBoolean();
                            output.writeBoolean(true);
                            Server.this.restart(updateMode, hasResources, showToast);
                            break;
                        }
                        return;
                    case 2:
                        boolean active = Restarter.getForegroundActivity(Server.this.context) != null;
                        output.writeBoolean(active);
                        if (!Log.isLoggable(Logging.LOG_TAG, 2)) {
                            break;
                        }
                        Log.v(Logging.LOG_TAG, "Received Ping message from the IDE; returned active = " + active);
                        break;
                    case 3:
                        if (!Log.isLoggable(Logging.LOG_TAG, 6)) {
                            break;
                        }
                        Log.e(Logging.LOG_TAG, "Unexpected message type: " + message);
                        break;
                    case 4:
                        if (!Log.isLoggable(Logging.LOG_TAG, 6)) {
                            break;
                        }
                        Log.e(Logging.LOG_TAG, "Unexpected message type: " + message);
                        break;
                    case ProtocolConstants.MESSAGE_RESTART_ACTIVITY /*5*/:
                        if (authenticate(input)) {
                            Activity activity = Restarter.getForegroundActivity(Server.this.context);
                            if (activity != null) {
                                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                                    Log.v(Logging.LOG_TAG, "Restarting activity per user request");
                                }
                                Restarter.restartActivityOnUiThread(activity);
                                break;
                            }
                            break;
                        }
                        return;
                    case ProtocolConstants.MESSAGE_SHOW_TOAST /*6*/:
                        String text = input.readUTF();
                        Activity foreground = Restarter.getForegroundActivity(Server.this.context);
                        if (foreground == null) {
                            if (!Log.isLoggable(Logging.LOG_TAG, 2)) {
                                break;
                            }
                            Log.v(Logging.LOG_TAG, "Couldn't show toast (no activity) : " + text);
                            break;
                        }
                        Restarter.showToast(foreground, text);
                        break;
                    case ProtocolConstants.MESSAGE_EOF /*7*/:
                        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                            Log.v(Logging.LOG_TAG, "Received EOF from the IDE");
                            return;
                        }
                        return;
                    default:
                        if (Log.isLoggable(Logging.LOG_TAG, 6)) {
                            Log.e(Logging.LOG_TAG, "Unexpected message type: " + message);
                            return;
                        }
                        return;
                }
            }
        }

        private boolean authenticate(DataInputStream input) throws IOException {
            long token = input.readLong();
            if (token == AppInfo.token) {
                return true;
            }
            Log.w(Logging.LOG_TAG, "Mismatched identity token from client; received " + token + " and expected " + AppInfo.token);
            Server.access$208();
            return false;
        }
    }

    private class SocketServerThread extends Thread {
        private SocketServerThread() {
        }

        public void run() {
            while (true) {
                try {
                    LocalServerSocket serverSocket = Server.this.serverSocket;
                    if (serverSocket != null) {
                        LocalSocket socket = serverSocket.accept();
                        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                            Log.v(Logging.LOG_TAG, "Received connection from IDE: spawning connection thread");
                        }
                        new SocketServerReplyThread(socket).run();
                        if (Server.wrongTokenCount > 50) {
                            break;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable e) {
                    if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                        Log.v(Logging.LOG_TAG, "Fatal error accepting connection on local socket", e);
                    }
                }
            }
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Stopping server: too many wrong token connections");
            }
            Server.this.serverSocket.close();
        }
    }

    static /* synthetic */ int access$208() {
        int i = wrongTokenCount;
        wrongTokenCount = i + 1;
        return i;
    }

    public static Server create(Context context) {
        return new Server(context.getPackageName(), context);
    }

    private Server(String packageName, Context context) {
        this.context = context;
        try {
            this.serverSocket = new LocalServerSocket(packageName);
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Starting server socket listening for package " + packageName + " on " + this.serverSocket.getLocalSocketAddress());
            }
            startServer();
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Started server for package " + packageName);
            }
        } catch (IOException e) {
            Log.e(Logging.LOG_TAG, "IO Error creating local socket at " + packageName, e);
        }
    }

    private void startServer() {
        try {
            new Thread(new SocketServerThread()).start();
        } catch (Throwable e) {
            if (Log.isLoggable(Logging.LOG_TAG, 6)) {
                Log.e(Logging.LOG_TAG, "Fatal error starting Instant Run server", e);
            }
        }
    }

    public void shutdown() {
        if (this.serverSocket != null) {
            try {
                this.serverSocket.close();
            } catch (IOException e) {
            }
            this.serverSocket = null;
        }
    }

    private static boolean isResourcePath(String path) {
        return path.equals(Paths.RESOURCE_FILE_NAME) || path.startsWith("res/");
    }

    private static boolean hasResources(List<ApplicationPatch> changes) {
        for (ApplicationPatch change : changes) {
            if (isResourcePath(change.getPath())) {
                return true;
            }
        }
        return false;
    }

    private int handlePatches(List<ApplicationPatch> changes, boolean hasResources, int updateMode) {
        if (hasResources) {
            FileManager.startUpdate();
        }
        for (ApplicationPatch change : changes) {
            String path = change.getPath();
            if (path.equals(Paths.RELOAD_DEX_FILE_NAME)) {
                updateMode = handleHotSwapPatch(updateMode, change);
            } else if (isResourcePath(path)) {
                updateMode = handleResourcePatch(updateMode, change, path);
            }
        }
        if (hasResources) {
            FileManager.finishUpdate(true);
        }
        return updateMode;
    }

    private static int handleResourcePatch(int updateMode, ApplicationPatch patch, String path) {
        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "Received resource changes (" + path + ")");
        }
        FileManager.writeAaptResources(path, patch.getBytes());
        return Math.max(updateMode, 2);
    }

    private int handleHotSwapPatch(int updateMode, ApplicationPatch patch) {
        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "Received incremental code patch");
        }
        try {
            String dexFile = FileManager.writeTempDexFile(patch.getBytes());
            if (dexFile == null) {
                Log.e(Logging.LOG_TAG, "No file to write the code to");
                return updateMode;
            }
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Reading live code from " + dexFile);
            }
            Class<?> aClass = Class.forName("com.android.tools.ir.runtime.AppPatchesLoaderImpl", true, new DexClassLoader(dexFile, this.context.getCacheDir().getPath(), FileManager.getNativeLibraryFolder().getPath(), getClass().getClassLoader()));
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Got the patcher class " + aClass);
            }
            PatchesLoader loader = (PatchesLoader) aClass.newInstance();
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Got the patcher instance " + loader);
            }
            String[] getPatchedClasses = (String[]) aClass.getDeclaredMethod("getPatchedClasses", new Class[0]).invoke(loader, new Object[0]);
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Got the list of classes ");
                for (String getPatchedClass : getPatchedClasses) {
                    Log.v(Logging.LOG_TAG, "class " + getPatchedClass);
                }
            }
            if (!loader.load()) {
                updateMode = 3;
            }
            return updateMode;
        } catch (Exception e) {
            Log.e(Logging.LOG_TAG, "Couldn't apply code changes", e);
            e.printStackTrace();
            updateMode = 3;
        } catch (Throwable e2) {
            Log.e(Logging.LOG_TAG, "Couldn't apply code changes", e2);
            updateMode = 3;
        }
    }

    private void restart(int updateMode, boolean incrementalResources, boolean toast) {
        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "Finished loading changes; update mode =" + updateMode);
        }
        if (updateMode == 0 || updateMode == 1) {
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "Applying incremental code without restart");
            }
            if (toast) {
                Activity foreground = Restarter.getForegroundActivity(this.context);
                if (foreground != null) {
                    Restarter.showToast(foreground, "Applied code changes without activity restart");
                    return;
                } else if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Couldn't show toast: no activity found");
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        List<Activity> activities = Restarter.getActivities(this.context, false);
        if (incrementalResources && updateMode == 2) {
            File file = FileManager.getExternalResourceFile();
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "About to update resource file=" + file + ", activities=" + activities);
            }
            if (file != null) {
                MonkeyPatcher.monkeyPatchExistingResources(this.context, file.getPath(), activities);
            } else {
                Log.e(Logging.LOG_TAG, "No resource file found to apply");
                updateMode = 3;
            }
        }
        Activity activity = Restarter.getForegroundActivity(this.context);
        if (updateMode == 2) {
            if (activity != null) {
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Restarting activity only!");
                }
                boolean handledRestart = false;
                try {
                    Object result = activity.getClass().getMethod("onHandleCodeChange", new Class[]{Long.TYPE}).invoke(activity, new Object[]{Long.valueOf(0)});
                    if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                        Log.v(Logging.LOG_TAG, "Activity " + activity + " provided manual restart method; return " + result);
                    }
                    if (Boolean.TRUE.equals(result)) {
                        handledRestart = true;
                        if (toast) {
                            Restarter.showToast(activity, "Applied changes");
                        }
                    }
                } catch (Throwable th) {
                }
                if (!handledRestart) {
                    if (toast) {
                        Restarter.showToast(activity, "Applied changes, restarted activity");
                    }
                    Restarter.restartActivityOnUiThread(activity);
                    return;
                }
                return;
            }
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, "No activity found, falling through to do a full app restart");
            }
            updateMode = 3;
        }
        if (updateMode != 3) {
            if (Log.isLoggable(Logging.LOG_TAG, 6)) {
                Log.e(Logging.LOG_TAG, "Unexpected update mode: " + updateMode);
            }
        } else if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "Waiting for app to be killed and restarted by the IDE...");
        }
    }
}
