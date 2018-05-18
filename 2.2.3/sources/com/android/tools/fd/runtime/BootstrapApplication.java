package com.android.tools.fd.runtime;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.android.tools.fd.common.Log;
import com.android.tools.fd.common.Log.Logging;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;

public class BootstrapApplication extends Application {
    public static final String LOG_TAG = "InstantRun";
    private String externalResourcePath;
    private Application realApplication;

    static {
        Log.logging = new Logging() {
            public void log(Level level, String string) {
                log(level, string, null);
            }

            public boolean isLoggable(Level level) {
                if (level == Level.SEVERE) {
                    return android.util.Log.isLoggable(BootstrapApplication.LOG_TAG, 6);
                }
                if (level == Level.FINE) {
                    return android.util.Log.isLoggable(BootstrapApplication.LOG_TAG, 2);
                }
                return android.util.Log.isLoggable(BootstrapApplication.LOG_TAG, 4);
            }

            public void log(Level level, String string, Throwable throwable) {
                if (level == Level.SEVERE) {
                    if (throwable == null) {
                        android.util.Log.e(BootstrapApplication.LOG_TAG, string);
                    } else {
                        android.util.Log.e(BootstrapApplication.LOG_TAG, string, throwable);
                    }
                } else if (level == Level.FINE) {
                    if (!android.util.Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                        return;
                    }
                    if (throwable == null) {
                        android.util.Log.v(BootstrapApplication.LOG_TAG, string);
                    } else {
                        android.util.Log.v(BootstrapApplication.LOG_TAG, string, throwable);
                    }
                } else if (!android.util.Log.isLoggable(BootstrapApplication.LOG_TAG, 4)) {
                } else {
                    if (throwable == null) {
                        android.util.Log.i(BootstrapApplication.LOG_TAG, string);
                    } else {
                        android.util.Log.i(BootstrapApplication.LOG_TAG, string, throwable);
                    }
                }
            }
        };
    }

    public BootstrapApplication() {
        android.util.Log.i(LOG_TAG, String.format("Instant Run Runtime started. Android package is %s, real application class is %s.", new Object[]{AppInfo.applicationId, AppInfo.applicationClass}));
    }

    private void createResources(long apkModified) {
        String str = null;
        FileManager.checkInbox();
        File file = FileManager.getExternalResourceFile();
        if (file != null) {
            str = file.getPath();
        }
        this.externalResourcePath = str;
        if (android.util.Log.isLoggable(LOG_TAG, 2)) {
            android.util.Log.v(LOG_TAG, "Resource override is " + this.externalResourcePath);
        }
        if (file != null) {
            try {
                long resourceModified = file.lastModified();
                if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                    android.util.Log.v(LOG_TAG, "Resource patch last modified: " + resourceModified);
                    android.util.Log.v(LOG_TAG, "APK last modified: " + apkModified + " " + (apkModified > resourceModified ? ">" : "<") + " resource patch");
                }
                if (apkModified == 0 || resourceModified <= apkModified) {
                    if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                        android.util.Log.v(LOG_TAG, "Ignoring resource file, older than APK");
                    }
                    this.externalResourcePath = null;
                }
            } catch (Throwable t) {
                android.util.Log.e(LOG_TAG, "Failed to check patch timestamps", t);
            }
        }
    }

    private static void setupClassLoaders(Context context, String codeCacheDir, long apkModified) {
        List<String> dexList = FileManager.getDexList(context, apkModified);
        Class<Server> server = Server.class;
        Class<MonkeyPatcher> patcher = MonkeyPatcher.class;
        if (dexList.isEmpty()) {
            android.util.Log.w(LOG_TAG, "No instant run dex files added to classpath");
            return;
        }
        String nativeLibraryPath;
        if (android.util.Log.isLoggable(LOG_TAG, 2)) {
            android.util.Log.v(LOG_TAG, "Bootstrapping class loader with dex list " + join('\n', dexList));
        }
        ClassLoader classLoader = BootstrapApplication.class.getClassLoader();
        try {
            nativeLibraryPath = (String) classLoader.getClass().getMethod("getLdLibraryPath", new Class[0]).invoke(classLoader, new Object[0]);
            if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                android.util.Log.v(LOG_TAG, "Native library path: " + nativeLibraryPath);
            }
        } catch (Throwable t) {
            android.util.Log.e(LOG_TAG, "Failed to determine native library path " + t.getMessage());
            nativeLibraryPath = FileManager.getNativeLibraryFolder().getPath();
        }
        IncrementalClassLoader.inject(classLoader, nativeLibraryPath, codeCacheDir, dexList);
    }

    public static String join(char on, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : list) {
            stringBuilder.append(item).append(on);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void createRealApplication() {
        if (AppInfo.applicationClass != null) {
            if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                android.util.Log.v(LOG_TAG, "About to create real application of class name = " + AppInfo.applicationClass);
            }
            try {
                Class<? extends Application> realClass = Class.forName(AppInfo.applicationClass);
                if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                    android.util.Log.v(LOG_TAG, "Created delegate app class successfully : " + realClass + " with class loader " + realClass.getClassLoader());
                }
                this.realApplication = (Application) realClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                    android.util.Log.v(LOG_TAG, "Created real app instance successfully :" + this.realApplication);
                    return;
                }
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        this.realApplication = new Application();
    }

    protected void attachBaseContext(Context context) {
        if (!AppInfo.usingApkSplits) {
            String apkFile = context.getApplicationInfo().sourceDir;
            long apkModified = apkFile != null ? new File(apkFile).lastModified() : 0;
            createResources(apkModified);
            setupClassLoaders(context, context.getCacheDir().getPath(), apkModified);
        }
        createRealApplication();
        super.attachBaseContext(context);
        if (this.realApplication != null) {
            try {
                Method attachBaseContext = ContextWrapper.class.getDeclaredMethod("attachBaseContext", new Class[]{Context.class});
                attachBaseContext.setAccessible(true);
                attachBaseContext.invoke(this.realApplication, new Object[]{context});
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public Context createPackageContext(String packageName, int flags) throws NameNotFoundException {
        Context c = this.realApplication.createPackageContext(packageName, flags);
        return c == null ? this.realApplication : c;
    }

    public void registerComponentCallbacks(ComponentCallbacks callback) {
        this.realApplication.registerComponentCallbacks(callback);
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        this.realApplication.registerActivityLifecycleCallbacks(callback);
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        this.realApplication.registerOnProvideAssistDataListener(callback);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        this.realApplication.unregisterComponentCallbacks(callback);
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        this.realApplication.unregisterActivityLifecycleCallbacks(callback);
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        this.realApplication.unregisterOnProvideAssistDataListener(callback);
    }

    public void onCreate() {
        if (AppInfo.usingApkSplits) {
            MonkeyPatcher.monkeyPatchApplication(this, this, this.realApplication, null);
        } else {
            MonkeyPatcher.monkeyPatchApplication(this, this, this.realApplication, this.externalResourcePath);
            MonkeyPatcher.monkeyPatchExistingResources(this, this.externalResourcePath, null);
        }
        super.onCreate();
        if (AppInfo.applicationId != null) {
            boolean foundPackage = false;
            try {
                boolean startServer;
                int pid = Process.myPid();
                List<RunningAppProcessInfo> processes = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                if (processes == null || processes.size() <= 1) {
                    startServer = true;
                } else {
                    startServer = false;
                    for (RunningAppProcessInfo processInfo : processes) {
                        if (AppInfo.applicationId.equals(processInfo.processName)) {
                            foundPackage = true;
                            if (processInfo.pid == pid) {
                                startServer = true;
                                break;
                            }
                        }
                    }
                    if (!(startServer || foundPackage)) {
                        startServer = true;
                        if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                            android.util.Log.v(LOG_TAG, "Multiprocess but didn't find process with package: starting server anyway");
                        }
                    }
                }
                if (startServer) {
                    Server.create(AppInfo.applicationId, this);
                }
            } catch (Throwable t) {
                if (android.util.Log.isLoggable(LOG_TAG, 2)) {
                    android.util.Log.v(LOG_TAG, "Failed during multi process check", t);
                }
                Server.create(AppInfo.applicationId, this);
            }
        }
        if (this.realApplication != null) {
            this.realApplication.onCreate();
        }
    }
}
