package com.android.tools.fd.runtime;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import java.util.List;

public class InstantRunService extends Service {
    private Server server;

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Log.i(Logging.LOG_TAG, "Starting Instant Run Server for " + getPackageName());
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
                        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                            Log.v(Logging.LOG_TAG, "Multiprocess but didn't find process with package: starting server anyway");
                        }
                    }
                }
                if (startServer) {
                    this.server = Server.create(this);
                    return;
                } else if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "In secondary process: Not starting server");
                    return;
                } else {
                    return;
                }
            } catch (Throwable t) {
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Failed during multi process check", t);
                }
                this.server = Server.create(this);
                return;
            }
        }
        this.server = Server.create(this);
    }

    public void onDestroy() {
        if (this.server != null) {
            Log.i(Logging.LOG_TAG, "Stopping Instant Run Server for " + getPackageName());
            this.server.shutdown();
        }
        super.onDestroy();
    }
}
