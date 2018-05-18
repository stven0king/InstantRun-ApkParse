package com.tanzx.instantrun;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.view.Display;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.io.InputStream;

public class MyAppication extends Application {
    public static volatile transient /* synthetic */ IncrementalChange $change;
    public static final long serialVersionUID = 0;

    MyAppication(Object[] objArr, InstantReloadException instantReloadException) {
        switch (((String) objArr[1]).hashCode()) {
            case 320516916:
                this();
                return;
            case 1159590441:
                return;
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "com/tanzx/instantrun/MyAppication"}));
        }
    }

    public static /* synthetic */ Object access$super(MyAppication myAppication, String str, Object... objArr) {
        switch (str.hashCode()) {
            case -2128160755:
                return super.toString();
            case -2119242196:
                return super.getSystemService((Class) objArr[0]);
            case -2116008609:
                super.startActivity((Intent) objArr[0], (Bundle) objArr[1]);
                return null;
            case -1935838630:
                return super.getColorStateList(((Number) objArr[0]).intValue());
            case -1932934201:
                super.setWallpaper((Bitmap) objArr[0]);
                return null;
            case -1921475715:
                return new Boolean(super.deleteSharedPreferences((String) objArr[0]));
            case -1920723310:
                super.sendStickyBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case -1920144170:
                return super.getClassLoader();
            case -1903246064:
                super.unregisterActivityLifecycleCallbacks((ActivityLifecycleCallbacks) objArr[0]);
                return null;
            case -1786273732:
                super.clearWallpaper();
                return null;
            case -1732453661:
                return new Boolean(super.moveSharedPreferencesFrom((Context) objArr[0], (String) objArr[1]));
            case -1689367812:
                return super.getMainLooper();
            case -1648999705:
                return super.getBaseContext();
            case -1554832987:
                super.finalize();
                return null;
            case -1502047401:
                super.enforceCallingOrSelfUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), (String) objArr[2]);
                return null;
            case -1485318024:
                return super.getCodeCacheDir();
            case -1483807804:
                return super.getString(((Number) objArr[0]).intValue(), (Object[]) objArr[1]);
            case -1467836826:
                super.enforceCallingUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), (String) objArr[2]);
                return null;
            case -1377658544:
                return super.fileList();
            case -1362550164:
                return super.createConfigurationContext((Configuration) objArr[0]);
            case -1349865163:
                return new Integer(super.checkCallingUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue()));
            case -1330876624:
                return new Boolean(super.isRestricted());
            case -1274460991:
                return new Integer(super.getWallpaperDesiredMinimumHeight());
            case -1261436153:
                return super.getWallpaper();
            case -1258591458:
                return super.getPackageName();
            case -1218355944:
                super.revokeUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case -1116895675:
                return super.createPackageContext((String) objArr[0], ((Number) objArr[1]).intValue());
            case -1110176650:
                return super.obtainStyledAttributes(((Number) objArr[0]).intValue(), (int[]) objArr[1]);
            case -1107583308:
                return super.openFileInput((String) objArr[0]);
            case -1076054347:
                super.unregisterReceiver((BroadcastReceiver) objArr[0]);
                return null;
            case -1021472056:
                super.wait(((Number) objArr[0]).longValue());
                return null;
            case -976790220:
                return super.getApplicationContext();
            case -962742886:
                super.onTrimMemory(((Number) objArr[0]).intValue());
                return null;
            case -911894097:
                return super.createDeviceProtectedStorageContext();
            case -878150729:
                super.registerActivityLifecycleCallbacks((ActivityLifecycleCallbacks) objArr[0]);
                return null;
            case -783227656:
                super.removeStickyBroadcast((Intent) objArr[0]);
                return null;
            case -771598921:
                return super.getNoBackupFilesDir();
            case -676692039:
                return new Boolean(super.moveDatabaseFrom((Context) objArr[0], (String) objArr[1]));
            case -645158372:
                super.unregisterComponentCallbacks((ComponentCallbacks) objArr[0]);
                return null;
            case -626801900:
                return super.getApplicationInfo();
            case -623553922:
                super.unbindService((ServiceConnection) objArr[0]);
                return null;
            case -600646834:
                super.sendOrderedBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1], (String) objArr[2], (BroadcastReceiver) objArr[3], (Handler) objArr[4], ((Number) objArr[5]).intValue(), (String) objArr[6], (Bundle) objArr[7]);
                return null;
            case -593599514:
                return new Integer(super.checkCallingOrSelfUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue()));
            case -583985582:
                return super.getObbDir();
            case -561536166:
                return super.getExternalCacheDir();
            case -533115309:
                super.sendBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1], (String) objArr[2]);
                return null;
            case -427921124:
                super.startActivities((Intent[]) objArr[0]);
                return null;
            case -406270088:
                return super.openOrCreateDatabase((String) objArr[0], ((Number) objArr[1]).intValue(), (CursorFactory) objArr[2]);
            case -389284119:
                return super.getExternalFilesDirs((String) objArr[0]);
            case -370434026:
                return super.startService((Intent) objArr[0]);
            case -367936228:
                return new Boolean(super.deleteFile((String) objArr[0]));
            case -364441911:
                super.onTerminate();
                return null;
            case -349229044:
                super.onConfigurationChanged((Configuration) objArr[0]);
                return null;
            case -299620925:
                super.registerComponentCallbacks((ComponentCallbacks) objArr[0]);
                return null;
            case -280716353:
                return new Boolean(super.bindService((Intent) objArr[0], (ServiceConnection) objArr[1], ((Number) objArr[2]).intValue()));
            case -256744805:
                return new Integer(super.checkPermission((String) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue()));
            case -232347918:
                return super.getDrawable(((Number) objArr[0]).intValue());
            case -172308168:
                return new Boolean(super.isDeviceProtectedStorage());
            case -159635284:
                super.setWallpaper((InputStream) objArr[0]);
                return null;
            case -51098230:
                super.sendOrderedBroadcast((Intent) objArr[0], (String) objArr[1]);
                return null;
            case -40033047:
                return super.getSharedPreferences((String) objArr[0], ((Number) objArr[1]).intValue());
            case 28656581:
                return super.getExternalFilesDir((String) objArr[0]);
            case 82670668:
                super.enforcePermission((String) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), (String) objArr[3]);
                return null;
            case 105425515:
                return super.obtainStyledAttributes((AttributeSet) objArr[0], (int[]) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue());
            case 116272469:
                super.startActivity((Intent) objArr[0]);
                return null;
            case 133224249:
                return super.getDataDir();
            case 154887605:
                super.sendStickyOrderedBroadcast((Intent) objArr[0], (BroadcastReceiver) objArr[1], (Handler) objArr[2], ((Number) objArr[3]).intValue(), (String) objArr[4], (Bundle) objArr[5]);
                return null;
            case 192936453:
                return super.getSystemServiceName((Class) objArr[0]);
            case 201261558:
                return super.getClass();
            case 281059718:
                super.unregisterOnProvideAssistDataListener((OnProvideAssistDataListener) objArr[0]);
                return null;
            case 323816587:
                return super.getString(((Number) objArr[0]).intValue());
            case 342401934:
                super.removeStickyBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case 361598322:
                return new Boolean(super.startInstrumentation((ComponentName) objArr[0], (String) objArr[1], (Bundle) objArr[2]));
            case 361690892:
                return super.getExternalMediaDirs();
            case 402547913:
                super.sendBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case 413640386:
                super.onCreate();
                return null;
            case 488359506:
                return super.getPackageManager();
            case 506020951:
                return super.getPackageCodePath();
            case 508196455:
                super.sendBroadcast((Intent) objArr[0], (String) objArr[1]);
                return null;
            case 514894248:
                super.attachBaseContext((Context) objArr[0]);
                return null;
            case 554472204:
                super.enforceCallingPermission((String) objArr[0], (String) objArr[1]);
                return null;
            case 592925556:
                super.sendStickyBroadcast((Intent) objArr[0]);
                return null;
            case 630071634:
                super.enforceUriPermission((Uri) objArr[0], (String) objArr[1], (String) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), (String) objArr[6]);
                return null;
            case 647580201:
                return new Integer(super.checkUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue()));
            case 664773775:
                return super.databaseList();
            case 689402016:
                return new Integer(super.getWallpaperDesiredMinimumWidth());
            case 698237531:
                return new Boolean(super.deleteDatabase((String) objArr[0]));
            case 712753272:
                return super.getContentResolver();
            case 743397380:
                super.startIntentSender((IntentSender) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue());
                return null;
            case 761478486:
                return super.getPackageResourcePath();
            case 922616583:
                return super.getResources();
            case 944385474:
                return new Integer(super.getColor(((Number) objArr[0]).intValue()));
            case 966976865:
                return super.openFileOutput((String) objArr[0], ((Number) objArr[1]).intValue());
            case 978076981:
                super.setTheme(((Number) objArr[0]).intValue());
                return null;
            case 981214139:
                super.enforceCallingOrSelfPermission((String) objArr[0], (String) objArr[1]);
                return null;
            case 1065143297:
                return super.getText(((Number) objArr[0]).intValue());
            case 1067388306:
                return super.getDir((String) objArr[0], ((Number) objArr[1]).intValue());
            case 1070661222:
                return super.registerReceiver((BroadcastReceiver) objArr[0], (IntentFilter) objArr[1], (String) objArr[2], (Handler) objArr[3]);
            case 1084679948:
                return super.peekWallpaper();
            case 1106102624:
                return super.registerReceiver((BroadcastReceiver) objArr[0], (IntentFilter) objArr[1]);
            case 1111017016:
                super.startActivities((Intent[]) objArr[0], (Bundle) objArr[1]);
                return null;
            case 1199311782:
                return super.getDatabasePath((String) objArr[0]);
            case 1222830949:
                return super.getFileStreamPath((String) objArr[0]);
            case 1270686685:
                super.onLowMemory();
                return null;
            case 1284851429:
                return super.getCacheDir();
            case 1403628309:
                return new Integer(super.hashCode());
            case 1437166753:
                super.sendStickyOrderedBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1], (BroadcastReceiver) objArr[2], (Handler) objArr[3], ((Number) objArr[4]).intValue(), (String) objArr[5], (Bundle) objArr[6]);
                return null;
            case 1474035477:
                return new Integer(super.checkUriPermission((Uri) objArr[0], (String) objArr[1], (String) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue()));
            case 1515366061:
                return super.obtainStyledAttributes((int[]) objArr[0]);
            case 1538025040:
                super.startIntentSender((IntentSender) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), (Bundle) objArr[5]);
                return null;
            case 1542479423:
                return super.createDisplayContext((Display) objArr[0]);
            case 1553572081:
                return super.getSystemService((String) objArr[0]);
            case 1609329947:
                return new Boolean(super.stopService((Intent) objArr[0]));
            case 1614070695:
                return new Integer(super.checkSelfPermission((String) objArr[0]));
            case 1615975956:
                super.sendOrderedBroadcast((Intent) objArr[0], (String) objArr[1], (BroadcastReceiver) objArr[2], (Handler) objArr[3], ((Number) objArr[4]).intValue(), (String) objArr[5], (Bundle) objArr[6]);
                return null;
            case 1627836879:
                return new Integer(super.checkCallingPermission((String) objArr[0]));
            case 1685568843:
                return super.obtainStyledAttributes((AttributeSet) objArr[0], (int[]) objArr[1]);
            case 1718256830:
                return new Integer(super.checkCallingOrSelfPermission((String) objArr[0]));
            case 1814730534:
                return new Boolean(super.equals(objArr[0]));
            case 1850165869:
                super.registerOnProvideAssistDataListener((OnProvideAssistDataListener) objArr[0]);
                return null;
            case 1908229466:
                return super.getFilesDir();
            case 1940660514:
                return super.getObbDirs();
            case 1984083782:
                return super.getTheme();
            case 1992548598:
                return super.openOrCreateDatabase((String) objArr[0], ((Number) objArr[1]).intValue(), (CursorFactory) objArr[2], (DatabaseErrorHandler) objArr[3]);
            case 2008219788:
                super.grantUriPermission((String) objArr[0], (Uri) objArr[1], ((Number) objArr[2]).intValue());
                return null;
            case 2025021518:
                return super.clone();
            case 2038901213:
                super.sendBroadcast((Intent) objArr[0]);
                return null;
            case 2039712810:
                return super.getExternalCacheDirs();
            case 2051394150:
                super.enforceUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), (String) objArr[4]);
                return null;
            case 2064626307:
                return super.getAssets();
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "com/tanzx/instantrun/MyAppication"}));
        }
    }

    public void onCreate() {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            incrementalChange.access$dispatch("onCreate.()V", this);
            return;
        }
        super.onCreate();
    }

    public MyAppication() {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Lcom/tanzx/instantrun/MyAppication;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
            Object[] objArr2 = (Object[]) objArr[0];
            this(objArr, null);
            objArr2[0] = this;
            incrementalChange.access$dispatch("init$body.(Lcom/tanzx/instantrun/MyAppication;[Ljava/lang/Object;)V", objArr2);
        }
    }
}
