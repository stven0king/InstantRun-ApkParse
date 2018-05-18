package com.tanzx.instantrun;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TaskStackBuilder;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import android.widget.Toolbar;
import com.android.tools.fd.runtime.BootstrapApplication;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public class InstantRunActivity extends AppCompatActivity {
    public static volatile transient /* synthetic */ IncrementalChange $change;
    public static final long serialVersionUID = 0;
    private int num;
    private TextView textView;

    InstantRunActivity(Object[] objArr, InstantReloadException instantReloadException) {
        switch (((String) objArr[1]).hashCode()) {
            case -2089128195:
                return;
            case 1403409127:
                this();
                return;
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "com/tanzx/instantrun/InstantRunActivity"}));
        }
    }

    public static /* synthetic */ Object access$super(InstantRunActivity instantRunActivity, String str, Object... objArr) {
        switch (str.hashCode()) {
            case -2147180915:
                super.onSaveInstanceState((Bundle) objArr[0]);
                return null;
            case -2146661417:
                super.showDialog(((Number) objArr[0]).intValue());
                return null;
            case -2128160755:
                return super.toString();
            case -2119242196:
                return super.getSystemService((Class) objArr[0]);
            case -2116008609:
                super.startActivity((Intent) objArr[0], (Bundle) objArr[1]);
                return null;
            case -2067683862:
                return new Boolean(super.onPreparePanel(((Number) objArr[0]).intValue(), (View) objArr[1], (Menu) objArr[2]));
            case -2042375299:
                super.setVisible(((Boolean) objArr[0]).booleanValue());
                return null;
            case -2012646654:
                super.onWindowFocusChanged(((Boolean) objArr[0]).booleanValue());
                return null;
            case -2012012406:
                return new Boolean(super.dispatchKeyShortcutEvent((KeyEvent) objArr[0]));
            case -2006928146:
                return super.createPendingResult(((Number) objArr[0]).intValue(), (Intent) objArr[1], ((Number) objArr[2]).intValue());
            case -2001885447:
                super.stopLockTask();
                return null;
            case -1991028125:
                return super.getCallingActivity();
            case -1989445603:
                super.closeContextMenu();
                return null;
            case -1973108070:
                super.finishActivityFromChild((Activity) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case -1970257541:
                super.setVolumeControlStream(((Number) objArr[0]).intValue());
                return null;
            case -1954109976:
                return new Boolean(super.isInMultiWindowMode());
            case -1949484118:
                super.onRestoreInstanceState((Bundle) objArr[0], (PersistableBundle) objArr[1]);
                return null;
            case -1935838630:
                return super.getColorStateList(((Number) objArr[0]).intValue());
            case -1932934201:
                super.setWallpaper((Bitmap) objArr[0]);
                return null;
            case -1929117203:
                super.onVisibleBehindCanceled();
                return null;
            case -1921475715:
                return new Boolean(super.deleteSharedPreferences((String) objArr[0]));
            case -1920723310:
                super.sendStickyBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case -1920144170:
                return super.getClassLoader();
            case -1910120743:
                return super.onWindowStartingActionMode((Callback) objArr[0], ((Number) objArr[1]).intValue());
            case -1875253839:
                super.dismissKeyboardShortcutsHelper();
                return null;
            case -1833452664:
                super.startActivityFromChild((Activity) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), (Bundle) objArr[3]);
                return null;
            case -1824869760:
                return new Boolean(super.onPrepareOptionsMenu((Menu) objArr[0]));
            case -1811304260:
                return new Boolean(super.isImmersive());
            case -1796734047:
                return new Boolean(super.showDialog(((Number) objArr[0]).intValue(), (Bundle) objArr[1]));
            case -1786273732:
                super.clearWallpaper();
                return null;
            case -1781634548:
                super.closeOptionsMenu();
                return null;
            case -1772888905:
                super.onSaveInstanceState((Bundle) objArr[0], (PersistableBundle) objArr[1]);
                return null;
            case -1754231978:
                super.setProgressBarIndeterminate(((Boolean) objArr[0]).booleanValue());
                return null;
            case -1749129850:
                super.onMultiWindowModeChanged(((Boolean) objArr[0]).booleanValue());
                return null;
            case -1744479168:
                super.setMediaController((MediaController) objArr[0]);
                return null;
            case -1732453661:
                return new Boolean(super.moveSharedPreferencesFrom((Context) objArr[0], (String) objArr[1]));
            case -1715303871:
                super.setActionBar((Toolbar) objArr[0]);
                return null;
            case -1708008179:
                super.onStateNotSaved();
                return null;
            case -1700762698:
                super.supportFinishAfterTransition();
                return null;
            case -1689367812:
                return super.getMainLooper();
            case -1663345066:
                super.onChildTitleChanged((Activity) objArr[0], (CharSequence) objArr[1]);
                return null;
            case -1653906805:
                super.setSupportProgressBarIndeterminate(((Boolean) objArr[0]).booleanValue());
                return null;
            case -1651465300:
                super.onCreateNavigateUpTaskStack((TaskStackBuilder) objArr[0]);
                return null;
            case -1648999705:
                return super.getBaseContext();
            case -1635453101:
                return new Boolean(super.onCreateOptionsMenu((Menu) objArr[0]));
            case -1630383126:
                super.startActivityForResult((Intent) objArr[0], ((Number) objArr[1]).intValue(), (Bundle) objArr[2]);
                return null;
            case -1628464379:
                super.startIntentSenderForResult((IntentSender) objArr[0], ((Number) objArr[1]).intValue(), (Intent) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue());
                return null;
            case -1601511123:
                super.onPanelClosed(((Number) objArr[0]).intValue(), (Menu) objArr[1]);
                return null;
            case -1597737654:
                super.unregisterForContextMenu((View) objArr[0]);
                return null;
            case -1596168386:
                return super.managedQuery((Uri) objArr[0], (String[]) objArr[1], (String) objArr[2], (String[]) objArr[3], (String) objArr[4]);
            case -1580823932:
                return new Boolean(super.onNavigateUpFromChild((Activity) objArr[0]));
            case -1567038203:
                super.setFeatureDrawableUri(((Number) objArr[0]).intValue(), (Uri) objArr[1]);
                return null;
            case -1563438637:
                super.onPrepareSupportNavigateUpTaskStack((android.support.v4.app.TaskStackBuilder) objArr[0]);
                return null;
            case -1563053631:
                return super.getLastNonConfigurationInstance();
            case -1554832987:
                super.finalize();
                return null;
            case -1545899961:
                return new Boolean(super.releaseInstance());
            case -1526884382:
                super.onActivityReenter(((Number) objArr[0]).intValue(), (Intent) objArr[1]);
                return null;
            case -1512679303:
                super.startSearch((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (Bundle) objArr[2], ((Boolean) objArr[3]).booleanValue());
                return null;
            case -1512649357:
                super.onResume();
                return null;
            case -1510369713:
                return new Boolean(super.onTrackballEvent((MotionEvent) objArr[0]));
            case -1504501726:
                super.onDestroy();
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
            case -1447998406:
                return new Boolean(super.onTouchEvent((MotionEvent) objArr[0]));
            case -1446660257:
                super.onPrepareNavigateUpTaskStack((TaskStackBuilder) objArr[0]);
                return null;
            case -1398848845:
                super.onPostResume();
                return null;
            case -1388205895:
                return new Boolean(super.onMenuItemSelected(((Number) objArr[0]).intValue(), (MenuItem) objArr[1]));
            case -1381466698:
                super.stopManagingCursor((Cursor) objArr[0]);
                return null;
            case -1377658544:
                return super.fileList();
            case -1364880825:
                super.setFeatureDrawableResource(((Number) objArr[0]).intValue(), ((Number) objArr[1]).intValue());
                return null;
            case -1362550164:
                return super.createConfigurationContext((Configuration) objArr[0]);
            case -1360644566:
                return new Boolean(super.shouldUpRecreateTask((Intent) objArr[0]));
            case -1349865163:
                return new Integer(super.checkCallingUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue()));
            case -1344529914:
                super.setTitle(((Number) objArr[0]).intValue());
                return null;
            case -1330876624:
                return new Boolean(super.isRestricted());
            case -1327523470:
                return super.onCreateDescription();
            case -1291272994:
                return super.getSupportParentActivityIntent();
            case -1274460991:
                return new Integer(super.getWallpaperDesiredMinimumHeight());
            case -1264569478:
                super.openOptionsMenu();
                return null;
            case -1261436153:
                return super.getWallpaper();
            case -1258591458:
                return super.getPackageName();
            case -1238136363:
                super.setExitSharedElementCallback((SharedElementCallback) objArr[0]);
                return null;
            case -1237633061:
                return new Integer(super.getTitleColor());
            case -1218355944:
                super.revokeUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case -1211749994:
                return super.onCreateDialog(((Number) objArr[0]).intValue());
            case -1188103088:
                return super.getVoiceInteractor();
            case -1158180317:
                return super.onWindowStartingSupportActionMode((ActionMode.Callback) objArr[0]);
            case -1145345097:
                return new Boolean(super.dispatchPopulateAccessibilityEvent((AccessibilityEvent) objArr[0]));
            case -1141736541:
                super.startIntentSenderFromChild((Activity) objArr[0], (IntentSender) objArr[1], ((Number) objArr[2]).intValue(), (Intent) objArr[3], ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), ((Number) objArr[6]).intValue());
                return null;
            case -1120807196:
                return super.getLayoutInflater();
            case -1116895675:
                return super.createPackageContext((String) objArr[0], ((Number) objArr[1]).intValue());
            case -1115540218:
                return super.onWindowStartingActionMode((Callback) objArr[0]);
            case -1115381115:
                super.onPrepareDialog(((Number) objArr[0]).intValue(), (Dialog) objArr[1]);
                return null;
            case -1110176650:
                return super.obtainStyledAttributes(((Number) objArr[0]).intValue(), (int[]) objArr[1]);
            case -1107583308:
                return super.openFileInput((String) objArr[0]);
            case -1106401236:
                super.onAttachFragment((Fragment) objArr[0]);
                return null;
            case -1076054347:
                super.unregisterReceiver((BroadcastReceiver) objArr[0]);
                return null;
            case -1053855858:
                super.onActionModeStarted((android.view.ActionMode) objArr[0]);
                return null;
            case -1025252350:
                super.setTaskDescription((TaskDescription) objArr[0]);
                return null;
            case -1024841183:
                return super.getCallingPackage();
            case -1021472056:
                super.wait(((Number) objArr[0]).longValue());
                return null;
            case -1021247703:
                return new Boolean(super.requestWindowFeature(((Number) objArr[0]).intValue()));
            case -978110490:
                return super.startActionMode((Callback) objArr[0], ((Number) objArr[1]).intValue());
            case -976790220:
                return super.getApplicationContext();
            case -962742886:
                super.onTrimMemory(((Number) objArr[0]).intValue());
                return null;
            case -956832564:
                super.putExtraData((ExtraData) objArr[0]);
                return null;
            case -946928039:
                return super.startActionMode((Callback) objArr[0]);
            case -936794346:
                super.onPictureInPictureModeChanged(((Boolean) objArr[0]).booleanValue());
                return null;
            case -911894097:
                return super.createDeviceProtectedStorageContext();
            case -908335631:
                super.startActivityFromFragment((Fragment) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), (Bundle) objArr[3]);
                return null;
            case -894847381:
                return new Boolean(super.showAssist((Bundle) objArr[0]));
            case -889668642:
                super.postponeEnterTransition();
                return null;
            case -884160602:
                return new Boolean(super.onKeyDown(((Number) objArr[0]).intValue(), (KeyEvent) objArr[1]));
            case -860668327:
                super.supportStartPostponedEnterTransition();
                return null;
            case -854984374:
                return super.getSupportMediaController();
            case -842839078:
                return super.getIntent();
            case -834926630:
                super.finishActivity(((Number) objArr[0]).intValue());
                return null;
            case -813556434:
                return super.getPreferences(((Number) objArr[0]).intValue());
            case -801135301:
                super.onUserLeaveHint();
                return null;
            case -787701764:
                return super.getSupportFragmentManager();
            case -783742144:
                super.onCreateContextMenu((ContextMenu) objArr[0], (View) objArr[1], (ContextMenuInfo) objArr[2]);
                return null;
            case -783227656:
                super.removeStickyBroadcast((Intent) objArr[0]);
                return null;
            case -775132968:
                return super.getComponentName();
            case -772306106:
                super.startActivityFromFragment((android.support.v4.app.Fragment) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue());
                return null;
            case -771598921:
                return super.getNoBackupFilesDir();
            case -754148941:
                super.setFeatureDrawableAlpha(((Number) objArr[0]).intValue(), ((Number) objArr[1]).intValue());
                return null;
            case -747367043:
                super.enterPictureInPictureMode();
                return null;
            case -739997161:
                super.onAttachFragment((android.support.v4.app.Fragment) objArr[0]);
                return null;
            case -731685428:
                super.startActivityFromChild((Activity) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue());
                return null;
            case -730211576:
                return new Boolean(super.onCreatePanelMenu(((Number) objArr[0]).intValue(), (Menu) objArr[1]));
            case -676692039:
                return new Boolean(super.moveDatabaseFrom((Context) objArr[0], (String) objArr[1]));
            case -663187577:
                return new Boolean(super.onSupportNavigateUp());
            case -657193226:
                super.onContextMenuClosed((Menu) objArr[0]);
                return null;
            case -645158372:
                super.unregisterComponentCallbacks((ComponentCallbacks) objArr[0]);
                return null;
            case -641568046:
                super.onCreate((Bundle) objArr[0]);
                return null;
            case -632893333:
                return new Boolean(super.onKeyLongPress(((Number) objArr[0]).intValue(), (KeyEvent) objArr[1]));
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
            case -579928354:
                return super.getExtraData((Class) objArr[0]);
            case -565022709:
                super.validateRequestPermissionsRequestCode(((Number) objArr[0]).intValue());
                return null;
            case -561536166:
                return super.getExternalCacheDir();
            case -543045568:
                super.requestPermissions((String[]) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case -533115309:
                super.sendBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1], (String) objArr[2]);
                return null;
            case -523441978:
                super.setEnterSharedElementCallback((android.app.SharedElementCallback) objArr[0]);
                return null;
            case -521108148:
                return new Boolean(super.onGenericMotionEvent((MotionEvent) objArr[0]));
            case -485599684:
                super.takeKeyEvents(((Boolean) objArr[0]).booleanValue());
                return null;
            case -451962688:
                super.onRestoreInstanceState((Bundle) objArr[0]);
                return null;
            case -449658531:
                super.onTitleChanged((CharSequence) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case -445489924:
                super.onPostCreate((Bundle) objArr[0], (PersistableBundle) objArr[1]);
                return null;
            case -440799600:
                return super.getFragmentManager();
            case -432656633:
                super.overridePendingTransition(((Number) objArr[0]).intValue(), ((Number) objArr[1]).intValue());
                return null;
            case -428399392:
                super.onCreateSupportNavigateUpTaskStack((android.support.v4.app.TaskStackBuilder) objArr[0]);
                return null;
            case -427921124:
                super.startActivities((Intent[]) objArr[0]);
                return null;
            case -412857127:
                return super.onCreateView((String) objArr[0], (Context) objArr[1], (AttributeSet) objArr[2]);
            case -406270088:
                return super.openOrCreateDatabase((String) objArr[0], ((Number) objArr[1]).intValue(), (CursorFactory) objArr[2]);
            case -406251089:
                super.startIntentSenderForResult((IntentSender) objArr[0], ((Number) objArr[1]).intValue(), (Intent) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), (Bundle) objArr[6]);
                return null;
            case -389284119:
                return super.getExternalFilesDirs((String) objArr[0]);
            case -386103215:
                super.startIntentSenderFromChild((Activity) objArr[0], (IntentSender) objArr[1], ((Number) objArr[2]).intValue(), (Intent) objArr[3], ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), ((Number) objArr[6]).intValue(), (Bundle) objArr[7]);
                return null;
            case -370434026:
                return super.startService((Intent) objArr[0]);
            case -367936228:
                return new Boolean(super.deleteFile((String) objArr[0]));
            case -349229044:
                super.onConfigurationChanged((Configuration) objArr[0]);
                return null;
            case -328499411:
                super.runOnUiThread((Runnable) objArr[0]);
                return null;
            case -325903536:
                return super.requestDragAndDropPermissions((DragEvent) objArr[0]);
            case -322248589:
                return new Boolean(super.onCreateThumbnail((Bitmap) objArr[0], (Canvas) objArr[1]));
            case -315360737:
                return new Boolean(super.onKeyUp(((Number) objArr[0]).intValue(), (KeyEvent) objArr[1]));
            case -300700976:
                return super.getLastCustomNonConfigurationInstance();
            case -299620925:
                super.registerComponentCallbacks((ComponentCallbacks) objArr[0]);
                return null;
            case -294950962:
                super.setFeatureDrawable(((Number) objArr[0]).intValue(), (Drawable) objArr[1]);
                return null;
            case -293022599:
                super.setContentTransitionManager((TransitionManager) objArr[0]);
                return null;
            case -280716353:
                return new Boolean(super.bindService((Intent) objArr[0], (ServiceConnection) objArr[1], ((Number) objArr[2]).intValue()));
            case -268822846:
                super.setSupportProgressBarVisibility(((Boolean) objArr[0]).booleanValue());
                return null;
            case -268786052:
                super.onLocalVoiceInteractionStarted();
                return null;
            case -261153143:
                return new Boolean(super.startNextMatchingActivity((Intent) objArr[0]));
            case -257219777:
                return super.onProvideReferrer();
            case -256744805:
                return new Integer(super.checkPermission((String) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue()));
            case -244620436:
                super.setSupportActionBar((android.support.v7.widget.Toolbar) objArr[0]);
                return null;
            case -242751949:
                return new Boolean(super.startNextMatchingActivity((Intent) objArr[0], (Bundle) objArr[1]));
            case -237096951:
                return super.onRetainNonConfigurationInstance();
            case -237085799:
                return new Boolean(super.moveTaskToBack(((Boolean) objArr[0]).booleanValue()));
            case -236884974:
                super.onSupportContentChanged();
                return null;
            case -232347918:
                return super.getDrawable(((Number) objArr[0]).intValue());
            case -212501619:
                super.onActionModeFinished((android.view.ActionMode) objArr[0]);
                return null;
            case -201279008:
                super.showLockTaskEscapeMessage();
                return null;
            case -199913269:
                return super.getContentTransitionManager();
            case -191939775:
                super.onContentChanged();
                return null;
            case -182141982:
                super.setIntent((Intent) objArr[0]);
                return null;
            case -172308168:
                return new Boolean(super.isDeviceProtectedStorage());
            case -169885823:
                super.requestShowKeyboardShortcuts();
                return null;
            case -159635284:
                super.setWallpaper((InputStream) objArr[0]);
                return null;
            case -157574108:
                super.setProgressBarIndeterminateVisibility(((Boolean) objArr[0]).booleanValue());
                return null;
            case -129020188:
                return new Boolean(super.onContextItemSelected((MenuItem) objArr[0]));
            case -124775396:
                return new Boolean(super.startActivityIfNeeded((Intent) objArr[0], ((Number) objArr[1]).intValue(), (Bundle) objArr[2]));
            case -92595176:
                super.finishFromChild((Activity) objArr[0]);
                return null;
            case -61650832:
                return super.getLoaderManager();
            case -51098230:
                super.sendOrderedBroadcast((Intent) objArr[0], (String) objArr[1]);
                return null;
            case -49297836:
                super.setImmersive(((Boolean) objArr[0]).booleanValue());
                return null;
            case -40033047:
                return super.getSharedPreferences((String) objArr[0], ((Number) objArr[1]).intValue());
            case 28656581:
                return super.getExternalFilesDir((String) objArr[0]);
            case 33078750:
                super.onApplyThemeResource((Theme) objArr[0], ((Number) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                return null;
            case 66113232:
                super.setExitSharedElementCallback((android.app.SharedElementCallback) objArr[0]);
                return null;
            case 71602588:
                super.onSupportActionModeFinished((ActionMode) objArr[0]);
                return null;
            case 77731138:
                super.setSupportProgress(((Number) objArr[0]).intValue());
                return null;
            case 82670668:
                super.enforcePermission((String) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), (String) objArr[3]);
                return null;
            case 105425515:
                return super.obtainStyledAttributes((AttributeSet) objArr[0], (int[]) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue());
            case 114588953:
                super.setDefaultKeyMode(((Number) objArr[0]).intValue());
                return null;
            case 116272469:
                super.startActivity((Intent) objArr[0]);
                return null;
            case 127696083:
                return super.getReferrer();
            case 133027723:
                super.onWindowAttributesChanged((LayoutParams) objArr[0]);
                return null;
            case 133224249:
                return super.getDataDir();
            case 134332931:
                super.startActivityFromFragment((Fragment) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue());
                return null;
            case 143326307:
                super.onBackPressed();
                return null;
            case 151409432:
                return super.onRetainCustomNonConfigurationInstance();
            case 154887605:
                super.sendStickyOrderedBroadcast((Intent) objArr[0], (BroadcastReceiver) objArr[1], (Handler) objArr[2], ((Number) objArr[3]).intValue(), (String) objArr[4], (Bundle) objArr[5]);
                return null;
            case 179534607:
                super.dump((String) objArr[0], (FileDescriptor) objArr[1], (PrintWriter) objArr[2], (String[]) objArr[3]);
                return null;
            case 188604040:
                super.onStop();
                return null;
            case 189950177:
                return super.getParent();
            case 192936453:
                return super.getSystemServiceName((Class) objArr[0]);
            case 201261558:
                return super.getClass();
            case 209747477:
                return super.getDrawerToggleDelegate();
            case 215736879:
                super.onPrepareDialog(((Number) objArr[0]).intValue(), (Dialog) objArr[1], (Bundle) objArr[2]);
                return null;
            case 223198551:
                return new Boolean(super.isVoiceInteractionRoot());
            case 224771354:
                return new Boolean(super.isDestroyed());
            case 232201144:
                return new Boolean(super.isLocalVoiceInteractionSupported());
            case 256941319:
                return new Integer(super.getVolumeControlStream());
            case 264300484:
                return super.getMenuInflater();
            case 277776542:
                return super.getCurrentFocus();
            case 311605593:
                return super.getSupportActionBar();
            case 323739864:
                super.setRequestedOrientation(((Number) objArr[0]).intValue());
                return null;
            case 323816587:
                return super.getString(((Number) objArr[0]).intValue());
            case 342401934:
                super.removeStickyBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case 356149802:
                super.dismissDialog(((Number) objArr[0]).intValue());
                return null;
            case 361598322:
                return new Boolean(super.startInstrumentation((ComponentName) objArr[0], (String) objArr[1], (Bundle) objArr[2]));
            case 361690892:
                return super.getExternalMediaDirs();
            case 366229479:
                return new Boolean(super.onMenuOpened(((Number) objArr[0]).intValue(), (Menu) objArr[1]));
            case 369126896:
                return new Integer(super.getTaskId());
            case 389417251:
                super.triggerSearch((String) objArr[0], (Bundle) objArr[1]);
                return null;
            case 402547913:
                super.sendBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1]);
                return null;
            case 430677542:
                return super.getMediaController();
            case 432240098:
                super.finishAffinity();
                return null;
            case 468603210:
                return new Boolean(super.onKeyShortcut(((Number) objArr[0]).intValue(), (KeyEvent) objArr[1]));
            case 474698654:
                super.onResumeFragments();
                return null;
            case 488359506:
                return super.getPackageManager();
            case 498687345:
                return super.getTitle();
            case 506020951:
                return super.getPackageCodePath();
            case 508196455:
                super.sendBroadcast((Intent) objArr[0], (String) objArr[1]);
                return null;
            case 514894248:
                super.attachBaseContext((Context) objArr[0]);
                return null;
            case 517731866:
                return new Boolean(super.supportRequestWindowFeature(((Number) objArr[0]).intValue()));
            case 533817968:
                return new Boolean(super.isFinishing());
            case 554472204:
                super.enforceCallingPermission((String) objArr[0], (String) objArr[1]);
                return null;
            case 557411162:
                return super.getSearchEvent();
            case 592925556:
                super.sendStickyBroadcast((Intent) objArr[0]);
                return null;
            case 595642473:
                super.invalidateOptionsMenu();
                return null;
            case 600947343:
                super.supportPostponeEnterTransition();
                return null;
            case 602429250:
                super.onRequestPermissionsResult(((Number) objArr[0]).intValue(), (String[]) objArr[1], (int[]) objArr[2]);
                return null;
            case 603335571:
                super.setFinishOnTouchOutside(((Boolean) objArr[0]).booleanValue());
                return null;
            case 630071634:
                super.enforceUriPermission((Uri) objArr[0], (String) objArr[1], (String) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), (String) objArr[6]);
                return null;
            case 647580201:
                return new Integer(super.checkUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue()));
            case 654718000:
                super.stopLocalVoiceInteraction();
                return null;
            case 663239282:
                return new Integer(super.getRequestedOrientation());
            case 664773775:
                return super.databaseList();
            case 677056085:
                return new Boolean(super.isVoiceInteraction());
            case 689402016:
                return new Integer(super.getWallpaperDesiredMinimumWidth());
            case 698237531:
                return new Boolean(super.deleteDatabase((String) objArr[0]));
            case 712753272:
                return super.getContentResolver();
            case 743397380:
                super.startIntentSender((IntentSender) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue());
                return null;
            case 746849712:
                return super.startSupportActionMode((ActionMode.Callback) objArr[0]);
            case 757106516:
                return new Boolean(super.requestVisibleBehind(((Boolean) objArr[0]).booleanValue()));
            case 761478486:
                return super.getPackageResourcePath();
            case 782036510:
                return new Boolean(super.shouldShowRequestPermissionRationale((String) objArr[0]));
            case 797441118:
                super.onPause();
                return null;
            case 812243512:
                super.onProvideAssistData((Bundle) objArr[0]);
                return null;
            case 819840342:
                super.startManagingCursor((Cursor) objArr[0]);
                return null;
            case 831436057:
                super.setSupportProgressBarIndeterminateVisibility(((Boolean) objArr[0]).booleanValue());
                return null;
            case 850345319:
                super.openContextMenu((View) objArr[0]);
                return null;
            case 885118356:
                super.finishAndRemoveTask();
                return null;
            case 886139607:
                return super.getDelegate();
            case 889348063:
                return new Boolean(super.onPrepareOptionsPanel((View) objArr[0], (Menu) objArr[1]));
            case 900905503:
                super.setEnterSharedElementCallback((SharedElementCallback) objArr[0]);
                return null;
            case 902425770:
                super.startActivityForResult((Intent) objArr[0], ((Number) objArr[1]).intValue());
                return null;
            case 921927566:
                super.setContentView((View) objArr[0], (ViewGroup.LayoutParams) objArr[1]);
                return null;
            case 922616583:
                return super.getResources();
            case 944385474:
                return new Integer(super.getColor(((Number) objArr[0]).intValue()));
            case 949399698:
                super.onDetachedFromWindow();
                return null;
            case 957566518:
                return new Boolean(super.onNavigateUp());
            case 966976865:
                return super.openFileOutput((String) objArr[0], ((Number) objArr[1]).intValue());
            case 968107227:
                super.reportFullyDrawn();
                return null;
            case 975965057:
                return super.getParentActivityIntent();
            case 978076981:
                super.setTheme(((Number) objArr[0]).intValue());
                return null;
            case 980588494:
                super.startActivityFromFragment((android.support.v4.app.Fragment) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), (Bundle) objArr[3]);
                return null;
            case 981214139:
                super.enforceCallingOrSelfPermission((String) objArr[0], (String) objArr[1]);
                return null;
            case 1025294348:
                super.onProvideAssistContent((AssistContent) objArr[0]);
                return null;
            case 1047335636:
                return super.onCreateDialog(((Number) objArr[0]).intValue(), (Bundle) objArr[1]);
            case 1049763651:
                super.registerForContextMenu((View) objArr[0]);
                return null;
            case 1055225029:
                super.finishAfterTransition();
                return null;
            case 1062055011:
                return super.getContentScene();
            case 1065143297:
                return super.getText(((Number) objArr[0]).intValue());
            case 1067388306:
                return super.getDir((String) objArr[0], ((Number) objArr[1]).intValue());
            case 1070024805:
                return new Boolean(super.navigateUpToFromChild((Activity) objArr[0], (Intent) objArr[1]));
            case 1070661222:
                return super.registerReceiver((BroadcastReceiver) objArr[0], (IntentFilter) objArr[1], (String) objArr[2], (Handler) objArr[3]);
            case 1082051997:
                return new Boolean(super.isChild());
            case 1084679948:
                return super.peekWallpaper();
            case 1106102624:
                return super.registerReceiver((BroadcastReceiver) objArr[0], (IntentFilter) objArr[1]);
            case 1111017016:
                super.startActivities((Intent[]) objArr[0], (Bundle) objArr[1]);
                return null;
            case 1123733599:
                return new Boolean(super.isChangingConfigurations());
            case 1133488156:
                super.setSupportMediaController((MediaControllerCompat) objArr[0]);
                return null;
            case 1150324634:
                super.finish();
                return null;
            case 1182266256:
                return super.getActionBar();
            case 1199311782:
                return super.getDatabasePath((String) objArr[0]);
            case 1208144271:
                super.setTitleColor(((Number) objArr[0]).intValue());
                return null;
            case 1220607435:
                return super.getLocalClassName();
            case 1222830949:
                return super.getFileStreamPath((String) objArr[0]);
            case 1235912506:
                super.supportNavigateUpTo((Intent) objArr[0]);
                return null;
            case 1246973220:
                return new Boolean(super.dispatchKeyEvent((KeyEvent) objArr[0]));
            case 1257714799:
                super.onActivityResult(((Number) objArr[0]).intValue(), ((Number) objArr[1]).intValue(), (Intent) objArr[2]);
                return null;
            case 1258286393:
                super.onSupportActionModeStarted((ActionMode) objArr[0]);
                return null;
            case 1260281423:
                return new Boolean(super.navigateUpTo((Intent) objArr[0]));
            case 1264052993:
                super.onNewIntent((Intent) objArr[0]);
                return null;
            case 1270686685:
                super.onLowMemory();
                return null;
            case 1278144004:
                return super.getWindowManager();
            case 1281559479:
                super.onRestart();
                return null;
            case 1284851429:
                return super.getCacheDir();
            case 1288659661:
                super.applyOverrideConfiguration((Configuration) objArr[0]);
                return null;
            case 1298332573:
                super.setResult(((Number) objArr[0]).intValue());
                return null;
            case 1308233817:
                return new Boolean(super.onSearchRequested((SearchEvent) objArr[0]));
            case 1320984464:
                return super.onCreatePanelView(((Number) objArr[0]).intValue());
            case 1340357437:
                return super.onCreateView((View) objArr[0], (String) objArr[1], (Context) objArr[2], (AttributeSet) objArr[3]);
            case 1354010372:
                super.startLocalVoiceInteraction((Bundle) objArr[0]);
                return null;
            case 1357142347:
                super.startIntentSenderFromFragment((android.support.v4.app.Fragment) objArr[0], (IntentSender) objArr[1], ((Number) objArr[2]).intValue(), (Intent) objArr[3], ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue(), ((Number) objArr[6]).intValue(), (Bundle) objArr[7]);
                return null;
            case 1391904137:
                return new Boolean(super.onKeyMultiple(((Number) objArr[0]).intValue(), ((Number) objArr[1]).intValue(), (KeyEvent) objArr[2]));
            case 1403628309:
                return new Integer(super.hashCode());
            case 1426222488:
                return new Boolean(super.isInPictureInPictureMode());
            case 1428545341:
                super.setSecondaryProgress(((Number) objArr[0]).intValue());
                return null;
            case 1437166753:
                super.sendStickyOrderedBroadcastAsUser((Intent) objArr[0], (UserHandle) objArr[1], (BroadcastReceiver) objArr[2], (Handler) objArr[3], ((Number) objArr[4]).intValue(), (String) objArr[5], (Bundle) objArr[6]);
                return null;
            case 1464460400:
                return super.getApplication();
            case 1474035477:
                return new Integer(super.checkUriPermission((Uri) objArr[0], (String) objArr[1], (String) objArr[2], ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), ((Number) objArr[5]).intValue()));
            case 1479324538:
                return new Integer(super.getChangingConfigurations());
            case 1515366061:
                return super.obtainStyledAttributes((int[]) objArr[0]);
            case 1525338969:
                super.startLockTask();
                return null;
            case 1538025040:
                super.startIntentSender((IntentSender) objArr[0], (Intent) objArr[1], ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), ((Number) objArr[4]).intValue(), (Bundle) objArr[5]);
                return null;
            case 1542479423:
                return super.createDisplayContext((Display) objArr[0]);
            case 1553572081:
                return super.getSystemService((String) objArr[0]);
            case 1609189330:
                return new Boolean(super.onSearchRequested());
            case 1609275863:
                super.setProgressBarVisibility(((Boolean) objArr[0]).booleanValue());
                return null;
            case 1609329947:
                return new Boolean(super.stopService((Intent) objArr[0]));
            case 1614070695:
                return new Integer(super.checkSelfPermission((String) objArr[0]));
            case 1615975956:
                super.sendOrderedBroadcast((Intent) objArr[0], (String) objArr[1], (BroadcastReceiver) objArr[2], (Handler) objArr[3], ((Number) objArr[4]).intValue(), (String) objArr[5], (Bundle) objArr[6]);
                return null;
            case 1617604079:
                super.onUserInteraction();
                return null;
            case 1626033557:
                super.onAttachedToWindow();
                return null;
            case 1627836879:
                return new Integer(super.checkCallingPermission((String) objArr[0]));
            case 1629601113:
                return new Boolean(super.hasWindowFocus());
            case 1632042018:
                super.setVrModeEnabled(((Boolean) objArr[0]).booleanValue(), (ComponentName) objArr[1]);
                return null;
            case 1683598447:
                super.setContentView((View) objArr[0]);
                return null;
            case 1685568843:
                return super.obtainStyledAttributes((AttributeSet) objArr[0], (int[]) objArr[1]);
            case 1718256830:
                return new Integer(super.checkCallingOrSelfPermission((String) objArr[0]));
            case 1750954440:
                super.onLocalVoiceInteractionStopped();
                return null;
            case 1765014364:
                return new Boolean(super.isTaskRoot());
            case 1770587104:
                super.setContentView(((Number) objArr[0]).intValue());
                return null;
            case 1814730534:
                return new Boolean(super.equals(objArr[0]));
            case 1824337728:
                return new Boolean(super.startActivityIfNeeded((Intent) objArr[0], ((Number) objArr[1]).intValue()));
            case 1835627922:
                super.onPostCreate((Bundle) objArr[0]);
                return null;
            case 1842319466:
                return new Boolean(super.dispatchTrackballEvent((MotionEvent) objArr[0]));
            case 1867171439:
                super.addContentView((View) objArr[0], (ViewGroup.LayoutParams) objArr[1]);
                return null;
            case 1874373038:
                return super.findViewById(((Number) objArr[0]).intValue());
            case 1876348903:
                super.onOptionsMenuClosed((Menu) objArr[0]);
                return null;
            case 1877256764:
                super.onCreate((Bundle) objArr[0], (PersistableBundle) objArr[1]);
                return null;
            case 1879378497:
                super.setTitle((CharSequence) objArr[0]);
                return null;
            case 1893326613:
                return new Boolean(super.onOptionsItemSelected((MenuItem) objArr[0]));
            case 1908229466:
                return super.getFilesDir();
            case 1940660514:
                return super.getObbDirs();
            case 1944176744:
                super.startPostponedEnterTransition();
                return null;
            case 1984083782:
                return super.getTheme();
            case 1992548598:
                return super.openOrCreateDatabase((String) objArr[0], ((Number) objArr[1]).intValue(), (CursorFactory) objArr[2], (DatabaseErrorHandler) objArr[3]);
            case 1996274778:
                super.setResult(((Number) objArr[0]).intValue(), (Intent) objArr[1]);
                return null;
            case 1996959810:
                return super.getSupportLoaderManager();
            case 2000782320:
                super.removeDialog(((Number) objArr[0]).intValue());
                return null;
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
            case 2042035911:
                super.onProvideKeyboardShortcuts((List) objArr[0], (Menu) objArr[1], ((Number) objArr[2]).intValue());
                return null;
            case 2051394150:
                super.enforceUriPermission((Uri) objArr[0], ((Number) objArr[1]).intValue(), ((Number) objArr[2]).intValue(), ((Number) objArr[3]).intValue(), (String) objArr[4]);
                return null;
            case 2058746343:
                return new Boolean(super.dispatchGenericMotionEvent((MotionEvent) objArr[0]));
            case 2064626307:
                return super.getAssets();
            case 2066955307:
                super.onEnterAnimationComplete();
                return null;
            case 2075560917:
                return new Boolean(super.dispatchTouchEvent((MotionEvent) objArr[0]));
            case 2079339533:
                super.setProgress(((Number) objArr[0]).intValue());
                return null;
            case 2095084022:
                super.recreate();
                return null;
            case 2125332505:
                return new Boolean(super.supportShouldUpRecreateTask((Intent) objArr[0]));
            case 2133689546:
                super.onStart();
                return null;
            case 2134622042:
                super.supportInvalidateOptionsMenu();
                return null;
            case 2136601924:
                return super.getWindow();
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "com/tanzx/instantrun/InstantRunActivity"}));
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            incrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", this, savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.textView = (TextView) findViewById(R.id.text);
        this.textView.setBackgroundResource(R.drawable.bg);
        this.textView.setText(BootstrapApplication.LOG_TAG);
        Utils utils = new Utils();
    }

    public InstantRunActivity() {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Lcom/tanzx/instantrun/InstantRunActivity;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
            Object[] objArr2 = (Object[]) objArr[0];
            this(objArr, null);
            objArr2[0] = this;
            incrementalChange.access$dispatch("init$body.(Lcom/tanzx/instantrun/InstantRunActivity;[Ljava/lang/Object;)V", objArr2);
        }
    }
}
