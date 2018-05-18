package com.android.tools.fd.runtime;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Restarter {
    public static void restartActivityOnUiThread(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Resources updated: notify activities");
                }
                Restarter.updateActivity(activity);
            }
        });
    }

    private static void restartActivity(Activity activity) {
        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "About to restart " + activity.getClass().getSimpleName());
        }
        while (activity.getParent() != null) {
            if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                Log.v(Logging.LOG_TAG, activity.getClass().getSimpleName() + " is not a top level activity; restarting " + activity.getParent().getClass().getSimpleName() + " instead");
            }
            activity = activity.getParent();
        }
        activity.recreate();
    }

    public static void restartApp(Context appContext, Collection<Activity> knownActivities, boolean toast) {
        if (!knownActivities.isEmpty()) {
            Context foreground = getForegroundActivity(appContext);
            if (foreground != null) {
                if (toast) {
                    showToast(foreground, "Restarting app to apply incompatible changes");
                }
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "RESTARTING APP");
                }
                Context context = foreground;
                ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 0, new Intent(context, foreground.getClass()), 268435456));
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Scheduling activity " + foreground + " to start after exiting process");
                }
            } else {
                showToast((Activity) knownActivities.iterator().next(), "Unable to restart app");
                if (Log.isLoggable(Logging.LOG_TAG, 2)) {
                    Log.v(Logging.LOG_TAG, "Couldn't find any foreground activities to restart for resource refresh");
                }
            }
            System.exit(0);
        }
    }

    static void showToast(final Activity activity, final String text) {
        if (Log.isLoggable(Logging.LOG_TAG, 2)) {
            Log.v(Logging.LOG_TAG, "About to show toast for activity " + activity + ": " + text);
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Context context = activity.getApplicationContext();
                    if (!(context instanceof ContextWrapper) || ((ContextWrapper) context).getBaseContext() != null) {
                        int duration = 0;
                        if (text.length() >= 60 || text.indexOf(10) != -1) {
                            duration = 1;
                        }
                        Toast.makeText(activity, text, duration).show();
                    } else if (Log.isLoggable(Logging.LOG_TAG, 5)) {
                        Log.w(Logging.LOG_TAG, "Couldn't show toast: no base context");
                    }
                } catch (Throwable e) {
                    if (Log.isLoggable(Logging.LOG_TAG, 5)) {
                        Log.w(Logging.LOG_TAG, "Couldn't show toast", e);
                    }
                }
            }
        });
    }

    public static Activity getForegroundActivity(Context context) {
        List<Activity> list = getActivities(context, true);
        return list.isEmpty() ? null : (Activity) list.get(0);
    }

    public static List<Activity> getActivities(Context context, boolean foregroundOnly) {
        List<Activity> list = new ArrayList();
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = MonkeyPatcher.getActivityThread(context, activityThreadClass);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);
            Object collection = activitiesField.get(activityThread);
            Collection c;
            if (collection instanceof HashMap) {
                c = ((HashMap) collection).values();
            } else {
                if (VERSION.SDK_INT >= 19 && (collection instanceof ArrayMap)) {
                    c = ((ArrayMap) collection).values();
                }
                return list;
            }
            for (Object activityRecord : c) {
                Class activityRecordClass = activityRecord.getClass();
                if (foregroundOnly) {
                    Field pausedField = activityRecordClass.getDeclaredField("paused");
                    pausedField.setAccessible(true);
                    if (pausedField.getBoolean(activityRecord)) {
                    }
                }
                Field activityField = activityRecordClass.getDeclaredField("activity");
                activityField.setAccessible(true);
                Activity activity = (Activity) activityField.get(activityRecord);
                if (activity != null) {
                    list.add(activity);
                }
            }
        } catch (Throwable th) {
        }
        return list;
    }

    private static void updateActivity(Activity activity) {
        restartActivity(activity);
    }
}
