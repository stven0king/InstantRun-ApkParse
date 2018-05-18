package com.android.tools.ir.server;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.util.Log;

public final class InstantRunContentProvider extends ContentProvider {
    public boolean onCreate() {
        if (isMainProcess()) {
            Log.i(Logging.LOG_TAG, "starting instant run server: is main process");
            Server.create(getContext());
        } else {
            Log.i(Logging.LOG_TAG, "not starting instant run server: not main process");
        }
        return true;
    }

    private boolean isMainProcess() {
        boolean isMainProcess = false;
        if (AppInfo.applicationId == null) {
            return false;
        }
        boolean foundPackage = false;
        int pid = Process.myPid();
        for (RunningAppProcessInfo processInfo : ((ActivityManager) getContext().getSystemService("activity")).getRunningAppProcesses()) {
            if (AppInfo.applicationId.equals(processInfo.processName)) {
                foundPackage = true;
                if (processInfo.pid == pid) {
                    isMainProcess = true;
                    break;
                }
            }
        }
        if (isMainProcess || foundPackage) {
            return isMainProcess;
        }
        Log.w(Logging.LOG_TAG, "considering this process main process:no process with this package found?!");
        return true;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("not a real content provider");
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("not a real content provider");
    }

    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("not a real content provider");
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new UnsupportedOperationException("not a real content provider");
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("not a real content provider");
    }
}
