<<<<<<< HEAD
# [个人博客地址 http://dandanlove.com/](http://dandanlove.com/)

# InstantRun从2.0到3.0，历史解毒

## 前言

![](https://upload-images.jianshu.io/upload_images/1319879-7358a6106f729d55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/620)


`Instant Run`已经出来3年了，为什么现在会想写这篇文章。从`Instant Run` 发布就已经有文章做了详细的介绍，但主要分为两类：一类是讲其主要实现原理或是讲 `Instant Run2.0`中的 `Application` 和 `ClassLoader` 的替换，另一类就是两者结合。但是在`Instant Run2.0` 以后包括（`2.3和3.0`）虽然主要的实现原理没做改变，但都不再有  `Application` 和 `ClassLoader` 的替换了。



而恰恰我是从 `Instant Run3.0` 开始分析的，所以在读完网上相关文章后感觉和自己实践结果偏差，使我产生一系列的为什么。本文章就是认真寻找其原理之后的产物。



>  文章会将相同的代码分别在 gradle：`2.0`  ~ `2.3`  ~ `3.0` 上的运行结果做对比，以及从源码的角度分析其结果的形成的原理。



## 关于 Instant Run

> Android Studio 2.0 中引入的 Instant Run 是 **Run** 和 **Debug** 命令的行为，可以大幅缩短应用更新的时间。尽管首次构建可能需要花费较长的时间，Instant Run 在向应用推送后续更新时则无需构建新的 APK，因此，这样可以更快地看到更改。原文[关于 Instant Run](https://developer.android.com/studio/run/#instant-run) 。



### 相关概念

> 普通构建整个*apk* → 部署*app* → *app*重启 → 重启*Activity*

> InstantRun*只构建修改的部分 → 部署修改的*dex*或资源 → 部署（热部署*|*温部署*|*冷部署）

- 热部署：更改现有方法的实现代码，无需重启app和Activity

- 温部署：app无需重启，但是activity需要重启，更改或移除现有资源。

- 冷部署：app需要重启，结构性的代码更改。



## Gradle2.2.3版本

### 环境

- os:Windows7
- AndroidStudio:2.2.3
- gradle:2.2.3
- Android:6.0
- [反编译工具：jadx](https://github.com/stven0king/jadx)

### 代码：

[源码以及反编译文件链接：https://gitee.com/dandanlove/InstantRun-ApkParse](https://gitee.com/dandanlove/InstantRun-ApkParse)

### 反编译结果

![bootstrapApplication.png](https://upload-images.jianshu.io/upload_images/1319879-f804a67fa70c5cdc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/820)

#### 目录结构

解压完apk之后，可以看到比以往多了一个 `instant-run.zip` 的文件。

```
 2.2.3-zip git:(master) ✗ unzip instant-run.zip -d ./instant-run
Archive:  instant-run.zip
  inflating: ./instant-run/com.android.support-support-v4-25.2.0_5d13af6de4318d640c0f4476df51368768e7d685-classes.dex
    inflating: ./instant-run/com.android.support-support-core-ui-25.2.0_ea8d7df920d33201f106dcb84c43d1eacaec7dd0-classes.dex
  inflating: ./instant-run/support-annotations-25.2.0_a33da78f501c6f0028ab51cf7a4a072129b233d3-classes.dex
  inflating: ./instant-run/com.android.support-support-vector-drawable-25.2.0_b68552cc8e884ffe451a9050485a027fab5221b6-classes.dex
  inflating: ./instant-run/com.android.support-support-compat-25.2.0_a30aa766fa9eb8931d774a9877ee62e7922594ea-classes.dex
  inflating: ./instant-run/com.android.support-support-core-utils-25.2.0_597f4e658a91af8509465a83255097ea293c4b0d-classes.dex
  inflating: ./instant-run/com.android.support-animated-vector-drawable-25.2.0_cee6b6e2c44697f52b0c7ae341d1e644be24f407-classes.dex
    inflating: ./instant-run/com.android.support-support-fragment-25.2.0_0b0115a9ee4c324b81c551aa7f986769013e71f8-classes.dex
      inflating: ./instant-run/com.android.support-support-media-compat-25.2.0_d4100160e6cd1e6586fd37853817402c8b1324dd-classes.dex
  inflating: ./instant-run/com.android.support-appcompat-v7-25.2.0_8ee0a5e1aed6951764492197789f674e0e0e9e51-classes.dex
  inflating: ./instant-run/slice_9-classes.dex
  inflating: ./instant-run/slice_8-classes.dex
  inflating: ./instant-run/slice_7-classes.dex
  inflating: ./instant-run/slice_6-classes.dex
  inflating: ./instant-run/slice_5-classes.dex
  inflating: ./instant-run/slice_4-classes.dex
  inflating: ./instant-run/slice_3-classes.dex
  inflating: ./instant-run/slice_2-classes.dex
  inflating: ./instant-run/slice_1-classes.dex
  inflating: ./instant-run/slice_0-classes.dex
```

`instant-run.zip` 文件解压之后为一些support包和slice的dex文件。

整体的包结构发生了一下变化：

```java
com.android.
------.---------.tools.fd.
------.---------.-------.--.common.*
------.---------.-------.--.dummy.*
------.---------.-------.--.runtime.*
------.---------.-------.ir.api.Disable.InstantRun
------.tanzx.
------.-------.instantrun
------.-------.-------------.BuildConfig
------.-------.-------------.InstantRunActivity
------.-------.-------------.MyApplication
------.-------.-------------.R
------.-------.-------------.Utils
```

多出了一个`com.android.tools.*`的目录结构，里面全部都是关于`instant-run`相关的代码。

#### AndroidManifest.xml

```html
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android" android:versionCode="1" android:versionName="1.0" package="com.tanzx.instantrun" platformBuildVersionCode="25" platformBuildVersionName="7.1.1">
    <uses-sdk android:minSdkVersion="15" android:targetSdkVersion="25"/>
    <application android:theme="@style/AppTheme" 
    	android:label="@string/app_name" 
    	android:icon="@mipmap/ic_launcher" 
    	android:name="com.android.tools.fd.runtime.BootstrapApplication" 
    	android:debuggable="true" 
    	android:allowBackup="true" 
    	android:supportsRtl="true" 
    	name="com.tanzx.instantrun.MyAppication">
        <activity android:name="com.tanzx.instantrun.InstantRunActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
</manifest>
```

可以看到应用程序的自定义 `MyApplication` 被 `BootstrapApplication` 替代了。

#### java类的修改

```java
public class InstantRunActivity extends AppCompatActivity {
    //给所有的类增加IncrementalChange类型的$change静态变量
    public static volatile transient /* synthetic */ IncrementalChange $change;
    public static final long serialVersionUID = 0;
    private int num;
    private TextView textView;
    //增加类的构造方法，方便于修改类的任何构造方法
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
    //增加类的super方法调用，方便于修改类的任何super方法
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
            /***各种父类方法的调用，与-2147180915类似***/
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "com/tanzx/instantrun/InstantRunActivity"}));
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        IncrementalChange incrementalChange = $change;
        //如果$change变量不为null，则执行$change中的对于的方法
        if (incrementalChange != null) {
            incrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", this, savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.textView = (TextView) findViewById(R.id.text);
        this.textView.setBackgroundResource(R.drawable.bg);
        this.textView.setText(BootstrapApplication.LOG_TAG);
    }

    public InstantRunActivity() {
        IncrementalChange incrementalChange = $change;
        //如果$change变量不为null，则执行$change中的对于的方法
        if (incrementalChange != null) {
            Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Lcom/tanzx/instantrun/InstantRunActivity;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
            Object[] objArr2 = (Object[]) objArr[0];
            this(objArr, null);
            objArr2[0] = this;
            incrementalChange.access$dispatch("init$body.(Lcom/tanzx/instantrun/InstantRunActivity;[Ljava/lang/Object;)V", objArr2);
        }
    }
}
```

```java
public interface IncrementalChange {
    Object access$dispatch(String str, Object... objArr);
}
```

上面我只举例了一个空的 `Activity` 的修改，`Instant-run` 实际会对每个类都进行修改，包括匿名内部类。

- 增加一种构造方法，方便于替换（或者修改）任何构造方法。
- 重写空构造方法，方便于替换该方法的实现。
- 增加 `access$super` 方法，方便于替换（或者修改）任何父类的方法。
- 所有的类（包括匿名内部类）都增加 `public static volatile transient IncrementalChange $change;` 成员变量。
- 在类的所有实现的方法都先判断 `$change` 是否为 `null` ，否则调用的是修复的类的方法。

PS：具体修复的过程看 **<u>handleHotSwapPatch</u>** 部分。

### 从Application替换开始

从 `AndroidManifest.xml` 中我们看到了`MyApplication` 被 `BootstrapApplication` 替代，那么我们可以想象当 `Application` 为 `Instant-run` 自己的时，那么它至少可以像加载插件一样在应用启动的时候（程序入口）加载替换自己的dex和资源文件，从而达到修改运行程序的目的。



接下来我们分析一下通过替换 `Application` 怎么加载自己的dex和资源文件。



#### BootstrapApplication

`BootstrapApplication` 重写了两个 `Application` 方法，分别为 `attachBaseContext` 和 `onCreate` 。

![Context.jpg](https://upload-images.jianshu.io/upload_images/1319879-1ffd45c5b44e4f8c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

`Application` 的基类为 `ContextWrapper` ，其真真的 `Context` 实现类为 `ContextImpl` 。

`attachBaseContext` 方法就是将 `ContextImpl` 和 `Application`  绑定在一起。

关于分裂apk以及安装参考：[Android Studio 配置构建变体](https://developer.android.com/studio/build/configure-apk-splits) 

```java
@Override
protected void attachBaseContext(Context context) {
    // As of Marshmallow, we use APK splits and don't need to rely on
    // reflection to inject classes and resources for coldswap
    //noinspection PointlessBooleanExpression
    //是否使用了apk分裂安装
    if (!AppInfo.usingApkSplits) {
        String apkFile = context.getApplicationInfo().sourceDir;
        long apkModified = apkFile != null ? new File(apkFile).lastModified() : 0L;
        //判断资源resource.ap_是否进行了修改，将其路径保存在externalResourcePath
        createResources(apkModified);
        //创建classloade
        //delegateClassLoader->PathClassLoader->IncrementalClassLoader->BootClassLoader
        setupClassLoaders(context, context.getCacheDir().getPath(), apkModified);
    }
    //创建正真的Application
    createRealApplication();

    // This is called from ActivityThread#handleBindApplication() -> LoadedApk#makeApplication().
    // Application#mApplication is changed right after this call, so we cannot do the monkey
    // patching here. So just forward this method to the real Application instance.
    super.attachBaseContext(context);

    if (realApplication != null) {
        try {
            Method attachBaseContext =
                    ContextWrapper.class.getDeclaredMethod("attachBaseContext", Context.class);
            attachBaseContext.setAccessible(true);
            //执行自己的Application的attachBaseContext方法
            attachBaseContext.invoke(realApplication, context);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
```

该方法的主要目的在于，创建自定义的 `ClassLoader` 和真真的 `Application`  实例。而 `BootstrapApplication` 只起到一个壳子的作用。

```java
@Override
    public void onCreate() {
        // As of Marshmallow, we use APK splits and don't need to rely on
        // reflection to inject classes and resources for coldswap
        //noinspection PointlessBooleanExpression
        if (!AppInfo.usingApkSplits) {
            //将BootstartApplication替换为realApplication
            MonkeyPatcher.monkeyPatchApplication(
                    BootstrapApplication.this, BootstrapApplication.this,
                    realApplication, externalResourcePath);
            MonkeyPatcher.monkeyPatchExistingResources(BootstrapApplication.this,
                    externalResourcePath, null);
        } else {
            // We still need to set the application instance in the LoadedApk etc
            // such that getApplication() returns the new application
            MonkeyPatcher.monkeyPatchApplication(
                    BootstrapApplication.this, BootstrapApplication.this,
                    realApplication, null);
        }
        super.onCreate();

        // Start server, unless we're in a multiprocess scenario and this isn't the
        // primary process
        if (AppInfo.applicationId != null) {
            try {
                boolean foundPackage = false;
                int pid = Process.myPid();
                ActivityManager manager = (ActivityManager) getSystemService(
                        Context.ACTIVITY_SERVICE);
                List<RunningAppProcessInfo> processes = manager.getRunningAppProcesses();

                boolean startServer;
                if (processes != null && processes.size() > 1) {
                    // Multiple processes: look at each, and if the process name matches
                    // the package name (for the current pid), it's the main process.
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
                    if (!startServer && !foundPackage) {
                        // Safety check: If for some reason we didn't even find the main package,
                        // start the server anyway. This safeguards against apps doing strange
                        // things with the process name.
                        startServer = true;
                        if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                            Log.v(LOG_TAG, "Multiprocess but didn't find process with package: "
                                    + "starting server anyway");
                        }
                    }
                } else {
                    // If there is only one process, start the server.
                    startServer = true;
                }
                //开启sokcet监听
                if (startServer) {
                    Server.create(AppInfo.applicationId, BootstrapApplication.this);
                }
            } catch (Throwable t) {
                if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                    Log.v(LOG_TAG, "Failed during multi process check", t);
                }
                Server.create(AppInfo.applicationId, BootstrapApplication.this);
            }
        }
		//调用真正的Application的onCreate方法
        if (realApplication != null) {
            realApplication.onCreate();
        }
    }
```

该方法的主要功能为，将运行时环境中的Application都替换为 `realApplication` 。然后开启 `Socket` 监听 `AndroidStudio`  是否有新的修改push给应用程序。

##### 创建资源文件

```java
private void createResources(long apkModified) {
    // Look for changes stashed in the inbox folder while the server was not running
    //校验是否有新的资源文件存储在inbox中
    FileManager.checkInbox();

    File file = FileManager.getExternalResourceFile();
    //外部导入的资源文件路径
    externalResourcePath = file != null ? file.getPath() : null;

    if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
        Log.v(LOG_TAG, "Resource override is " + externalResourcePath);
    }

    if (file != null) {
        try {
            //获取文件的修改时间
            long resourceModified = file.lastModified();
            if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                Log.v(LOG_TAG, "Resource patch last modified: " + resourceModified);
                Log.v(LOG_TAG, "APK last modified: " + apkModified + " " +
                        (apkModified > resourceModified ? ">" : "<") + " resource patch");
            }
            //如果没有修改，或者修改时间不大于apk的修改时间，那么相当于没有改变资源
            if (apkModified == 0L || resourceModified <= apkModified) {
                if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                    Log.v(LOG_TAG, "Ignoring resource file, older than APK");
                }
                externalResourcePath = null;
            }
        } catch (Throwable t) {
            Log.e(LOG_TAG, "Failed to check patch timestamps", t);
        }
    }
}
```

##### 创建ClassLoader

关于JVM的ClassLoader我们都是知道只在双亲委派机制的基础上实现的，那么 `instant-run` 也正是利用这一特点来创建加载自己指定的 `dex` 的 `ClassLoader` 。PS：忘掉的同学可以参数文章： [自定义ClassLoader和双亲委派机制](http://dandanlove.com/2017/02/23/java-classloader/) 。

```java
private static void setupClassLoaders(Context context, String codeCacheDir, long apkModified) {
    //目录"/data/data/" + applicationId + "/files/instant-run/dex"下的文件列表
    List<String> dexList = FileManager.getDexList(context, apkModified);

    // Make sure class loader finds these
    @SuppressWarnings("unused") Class<Server> server = Server.class;
    @SuppressWarnings("unused") Class<MonkeyPatcher> patcher = MonkeyPatcher.class;

    if (!dexList.isEmpty()) {
        if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
            Log.v(LOG_TAG, "Bootstrapping class loader with dex list " + join('\n', dexList));
        }
        //PathClassLoader
        ClassLoader classLoader = BootstrapApplication.class.getClassLoader();
        String nativeLibraryPath;
        try {
            nativeLibraryPath = (String) classLoader.getClass().getMethod("getLdLibraryPath")
                            .invoke(classLoader);
            if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                Log.v(LOG_TAG, "Native library path: " + nativeLibraryPath);
            }
        } catch (Throwable t) {
            Log.e(LOG_TAG, "Failed to determine native library path " + t.getMessage());
            //目录"/data/data/" + applicationId + "/lib"
            nativeLibraryPath = FileManager.getNativeLibraryFolder().getPath();
        }
        IncrementalClassLoader.inject(
                classLoader,
                nativeLibraryPath,
                codeCacheDir,
                dexList);
    }
}
```

可以看到主要是获取 `classloader` 、 `nativeLibraryPath`  和 `dexList` 再调用 `IncrementalClassLoader.inject` 方法。



我们接下来看创建的 `IncrementalClassLoader` :

```java
public class IncrementalClassLoader extends ClassLoader {
    public static final boolean DEBUG_CLASS_LOADING = false;
    private final DelegateClassLoader delegateClassLoader;

    private static class DelegateClassLoader extends BaseDexClassLoader {
        private DelegateClassLoader(String dexPath, File optimizedDirectory, String libraryPath, ClassLoader parent) {
            super(dexPath, optimizedDirectory, libraryPath, parent);
        }

        public Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                return super.findClass(name);
            } catch (ClassNotFoundException e) {
                throw e;
            }
        }
    }

    public IncrementalClassLoader(ClassLoader original, String nativeLibraryPath, String codeCacheDir, List<String> dexes) {
        //设置为original的parent为IncrementalClassLoader的parent
        //即：IncrementalClassLoader为BootClassLoader
        super(original.getParent());
        //delegateClassLoader的parent为PathClassLoader
        this.delegateClassLoader = createDelegateClassLoader(nativeLibraryPath, codeCacheDir, dexes, original);
    }

    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            return this.delegateClassLoader.findClass(className);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }
    /***部分代码省略***/
    public static ClassLoader inject(ClassLoader classLoader, String nativeLibraryPath, String codeCacheDir, List<String> dexes) {
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(classLoader, nativeLibraryPath, codeCacheDir, dexes);
        //设置incrementalClassLoader为PathClassLoader的parent
        setParent(classLoader, incrementalClassLoader);
        return incrementalClassLoader;
    }
}
```

`IncrementalClassLoader` 继承 `ClassLoader`  ，但从其 `findClass`  的实现看出 `IncrementalClassLoader` 在进行 `class` 的加载时用的是内部类 `DelegateClassLoader` 。同时 `IncrementalClassLoader` 又作为 `PathClassLoader` 的parent。

`DelegateClassLoader` 继承 `BaseDexClassLoader` 可以加载自定义路径下的 `dex` 和 `jar` 包中的 `class` 。PS：AndroidDexClassLoader相关文章可以参考：[Android类加载之PathClassLoader和DexClassLoader](http://dandanlove.com/2017/02/23/pathclassloader-dexclassloader/)

![classloader.png](https://upload-images.jianshu.io/upload_images/1319879-64f06bfca42fdec1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/620)

如上图所示：整个类加载机制建造起来之后 `DelegateClassLoader` 为加载应用程序的 `dex` 的类加载器。



##### 创建真正的Application

`Instant-run` 的 `Appinfo.java` 文件为对Application的配置信息。

```java
public class AppInfo {
    public static String applicationClass = "com.tanzx.instantrun.MyAppication";
    public static String applicationId = BuildConfig.APPLICATION_ID;
    public static long token = -4151428381996933796L;
    public static boolean usingApkSplits = false;
}
```

再看看 `BootstrapApplication` 中真正的Application的创建：

```java
 private void createRealApplication() {
    //是否有应用自己的Application
    if (AppInfo.applicationClass != null) {
        if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
            Log.v(LOG_TAG, "About to create real application of class name = " +
                    AppInfo.applicationClass);
        }

        try {
            @SuppressWarnings("unchecked")
            Class<? extends Application> realClass =
                    (Class<? extends Application>) Class.forName(AppInfo.applicationClass);
            if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                Log.v(LOG_TAG, "Created delegate app class successfully : " + realClass +
                        " with class loader " + realClass.getClassLoader());
            }
            Constructor<? extends Application> constructor = realClass.getConstructor();
            //自定的Application实例
            realApplication = constructor.newInstance();
            if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
                Log.v(LOG_TAG, "Created real app instance successfully :" + realApplication);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    } else {
        //没有自定义，则创建原生的Application
        realApplication = new Application();
    }
}
```

##### 替换Application

```java
public class MonkeyPatcher {
    public static void monkeyPatchApplication(Context context, Application bootstrap, Application realApplication, String externalResourceFile) {
        Class<?> activityThread;
        Class<?> loadedApkClass;
        try {
            //获取ActivityThread实例
            activityThread = Class.forName("android.app.ActivityThread");
            Object currentActivityThread = getActivityThread(context, activityThread);
            Field mInitialApplication = activityThread.getDeclaredField("mInitialApplication");
            mInitialApplication.setAccessible(true);
            //替换ActivityThread的mInitialApplication成员变量
            Application initialApplication = (Application) mInitialApplication.get(currentActivityThread);
            if (realApplication != null && initialApplication == bootstrap) {
                mInitialApplication.set(currentActivityThread, realApplication);
            }
            //替换ActivityThread的mAllApplications队列中的BootstrapApplication为realApplication
            if (realApplication != null) {
                Field mAllApplications = activityThread.getDeclaredField("mAllApplications");
                mAllApplications.setAccessible(true);
                List<Application> allApplications = (List) mAllApplications.get(currentActivityThread);
                for (int i = 0; i < allApplications.size(); i++) {
                    if (allApplications.get(i) == bootstrap) {
                        allApplications.set(i, realApplication);
                    }
                }
            }
            loadedApkClass = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            loadedApkClass = Class.forName("android.app.ActivityThread$PackageInfo");
        } catch (Throwable e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
        }
        Field mApplication = loadedApkClass.getDeclaredField("mApplication");
        mApplication.setAccessible(true);
        Field mResDir = loadedApkClass.getDeclaredField("mResDir");
        mResDir.setAccessible(true);
        Field mLoadedApk = null;
        try {
            mLoadedApk = Application.class.getDeclaredField("mLoadedApk");
        } catch (NoSuchFieldException e3) {
        }
        //final ArrayMap<String, WeakReference<LoadedApk>> mPackages
        //final ArrayMap<String, WeakReference<LoadedApk>> mResourcePackages
        for (String fieldName : new String[]{"mPackages", "mResourcePackages"}) {
            Field field = activityThread.getDeclaredField(fieldName);
            field.setAccessible(true);
            for (Entry<String, WeakReference<?>> entry : ((Map) field.get(currentActivityThread)).entrySet()) {
                Object loadedApk = ((WeakReference) entry.getValue()).get();
                if (loadedApk != null && mApplication.get(loadedApk) == bootstrap) {
                    //将ActivityThread的mPackages|mResourcePackages的LoadedApk
                    //LoadedApk的成员变量mApplication的BootstrapApplication替换为realApplication
                    if (realApplication != null) {
                        mApplication.set(loadedApk, realApplication);
                    }
                    //LoadedApk的成员变量mResDir替换为externalResourceFile
                    if (externalResourceFile != null) {
                        mResDir.set(loadedApk, externalResourceFile);
                    }
                    //将realApplication的mLoadedApk替换为BootstrapApplication的mLoadedApk
                    if (!(realApplication == null || mLoadedApk == null)) {
                        mLoadedApk.set(realApplication, loadedApk);
                    }
                }
            }
        }
    }

    public static Object getActivityThread(Context context, Class<?> activityThread) {
        if (activityThread == null) {
            try {
                activityThread = Class.forName("android.app.ActivityThread");
            } catch (Throwable th) {
                return null;
            }
        }
        //获取ActivityThread的静态变量sCurrentActivityThread
        Method m = activityThread.getMethod("currentActivityThread", new Class[0]);
        m.setAccessible(true);
        Object currentActivityThread = m.invoke(null, new Object[0]);
        if (currentActivityThread != null || context == null) {
            return currentActivityThread;
        }
        //获取BootstrapApplication的mLoadedApk
        Field mLoadedApk = context.getClass().getField("mLoadedApk");
        mLoadedApk.setAccessible(true);
        Object apk = mLoadedApk.get(context);
        Field mActivityThreadField = apk.getClass().getDeclaredField("mActivityThread");
        mActivityThreadField.setAccessible(true);
        //返回mLoadedApk的成员变量mActivityThread
        return mActivityThreadField.get(apk);
    }
    /***部分代码省略***/
}
```

- 获取ActivityThread实例
  - 先获取ActivityThread的静态变量sCurrentActivityThread；
  - 否则获取Application对象的成员变mLoadedApk的成员对象mActivityThread；
- 替换ActivityThread的mInitialApplication为realApplication
- 替换ActivityThread的mAllApplications中的所有的BootstrapApplication为realApplication
- 替换ActivityThread的mPackages,mResourcePackages中的mLoaderApk中的application为realApplication。
- 替换realApplication中的mLoadedApk为BootstrapApplication的MLoadedApk

##### 替换资源文件

```java
public static void monkeyPatchExistingResources(Context context, String externalResourceFile, Collection<Activity> activities) {
    Field mResourcesImpl;
    Object resourceImpl;
    Field implAssets;
    if (externalResourceFile != null) {
        //构造自己的AssetManager
        AssetManager newAssetManager = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        Method mAddAssetPath = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        mAddAssetPath.setAccessible(true);
        //将当前的资源文件路径添加到AssetManager中
        if (((Integer) mAddAssetPath.invoke(newAssetManager, new Object[]{externalResourceFile})).intValue() == 0) {
            throw new IllegalStateException("Could not create new AssetManager");
        }
        Resources resources;
        Field mAssets;
        Method mEnsureStringBlocks = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
        mEnsureStringBlocks.setAccessible(true);
        //进行资源初始化StringBlock对象
        mEnsureStringBlocks.invoke(newAssetManager, new Object[0]);
        if (activities != null) {
            /***部分代码省略***/
        }
        Field fMActiveResources;
        Collection<WeakReference<Resources>> references;
        //获取当前JVM中的ResourcesManager的final ArrayMap<ResourcesKey, WeakReference<Resources> > mActiveResources
        if (VERSION.SDK_INT >= 19) {
            Class<?> resourcesManagerClass = Class.forName("android.app.ResourcesManager");
            Method mGetInstance = resourcesManagerClass.getDeclaredMethod("getInstance", new Class[0]);
            mGetInstance.setAccessible(true);
            Object resourcesManager = mGetInstance.invoke(null, new Object[0]);
            try {
                fMActiveResources = resourcesManagerClass.getDeclaredField("mActiveResources");
                fMActiveResources.setAccessible(true);
                references = ((ArrayMap) fMActiveResources.get(resourcesManager)).values();
            } catch (NoSuchFieldException e4) {
                Field mResourceReferences = resourcesManagerClass.getDeclaredField("mResourceReferences");
                mResourceReferences.setAccessible(true);
                references = (Collection) mResourceReferences.get(resourcesManager);
            }
        } else {
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            fMActiveResources = activityThread.getDeclaredField("mActiveResources");
            fMActiveResources.setAccessible(true);
            references = ((HashMap) fMActiveResources.get(getActivityThread(context, activityThread))).values();
        }
        //循环便利当前Resources，将其成员变量mAssets指向自定义的newAssetManager
        for (WeakReference<Resources> wr : references) {
            resources = (Resources) wr.get();
            if (resources != null) {
                try {
                    mAssets = Resources.class.getDeclaredField("mAssets");
                    mAssets.setAccessible(true);
                    mAssets.set(resources, newAssetManager);
                } catch (Throwable th) {
                    mResourcesImpl = Resources.class.getDeclaredField("mResourcesImpl");
                    mResourcesImpl.setAccessible(true);
                    resourceImpl = mResourcesImpl.get(resources);
                    implAssets = resourceImpl.getClass().getDeclaredField("mAssets");
                    implAssets.setAccessible(true);
                    implAssets.set(resourceImpl, newAssetManager);
                }
                //更新资源
                resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
            }
        }
    }
}
```

#### Socket监听

执行完 `Application.onCreate` ，开启Socket监听。

```java
public static void create(String packageName, Application application) {
    Server server = new Server(packageName, application);
}
```

##### run

我们分析Socket线程的主要的run方法：

```java
private class SocketServerReplyThread extends Thread {
    private final LocalSocket mSocket;

    SocketServerReplyThread(LocalSocket socket) {
        this.mSocket = socket;
    }

    public void run() {
        DataInputStream input;
        DataOutputStream output;
        try {
            input = new DataInputStream(this.mSocket.getInputStream());
            output = new DataOutputStream(this.mSocket.getOutputStream());
            //分发消息
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
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "Fatal error receiving messages", e3);
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
	/***部分代码省略***/
}
```

##### handle

根据不同的version，进行不同类型的消息处理：

```java
private void handle(DataInputStream input, DataOutputStream output) throws IOException {
    long magic = input.readLong();
    if (magic != ProtocolConstants.PROTOCOL_IDENTIFIER) {
        Log.w(BootstrapApplication.LOG_TAG, "Unrecognized header format " + Long.toHexString(magic));
        return;
    }
    //读取消息类型
    int version = input.readInt();
    output.writeInt(4);
    if (version != 4) {
        Log.w(BootstrapApplication.LOG_TAG, "Mismatched protocol versions; app is using version 4 and tool is using version " + version);
        return;
    }
    while (true) {
        int message = input.readInt();
        String path;
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
            /***部分代码省略***/
            case 7://消息结束发送
                if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                    Log.v(BootstrapApplication.LOG_TAG, "Received EOF from the IDE");
                    return;
                }
                return;
            default:
                if (Log.isLoggable(BootstrapApplication.LOG_TAG, 6)) {
                    Log.e(BootstrapApplication.LOG_TAG, "Unexpected message type: " + message);
                    return;
                }
                return;
        }
    }
}
//判断是否为当前Application发送的信息
private boolean authenticate(DataInputStream input) throws IOException {
    long token = input.readLong();
    if (token == AppInfo.token) {
        return true;
    }
    Log.w(BootstrapApplication.LOG_TAG, "Mismatched identity token from client; received " + token + " and expected " + AppInfo.token);
    Server.access$208();
    return false;
}
```

### 处理服务端（AndroidStudio-IDE）消息

#### handlePatches

根据发送过来的文件进行不同的操作：

```java
private int handlePatches(List<ApplicationPatch> changes, boolean hasResources, int updateMode) {
    if (hasResources) {
        FileManager.startUpdate();
    }
    for (ApplicationPatch change : changes) {
        String path = change.getPath();
        //文件以“.dex”结尾
        if (path.endsWith(FileManager.CLASSES_DEX_SUFFIX)) {
            //冷交换
            handleColdSwapPatch(change);
            boolean canHotSwap = false;
            for (ApplicationPatch c : changes) {
                if (c.getPath().equals(Paths.RELOAD_DEX_FILE_NAME)) {
                    canHotSwap = true;
                    break;
                }
            }
            if (!canHotSwap) {
                updateMode = 3;
            }
        } else if (path.equals(Paths.RELOAD_DEX_FILE_NAME)) {//文件名为“classes.dex.3”
            //热交换
            updateMode = handleHotSwapPatch(updateMode, change);
        } else if (isResourcePath(path)) {
            //资源交换(温部署)
            updateMode = handleResourcePatch(updateMode, change, path);
        }
    }
    if (hasResources) {
        FileManager.finishUpdate(true);
    }
    return updateMode;
}
private static boolean isResourcePath(String path) {
    //判断文件是否为“resources.ap_”，或者文件以“res/"开头
    return path.equals(Paths.RESOURCE_FILE_NAME) || path.startsWith("res/");
}
```

#### handleColdSwapPatch

```java
private static void handleColdSwapPatch(ApplicationPatch patch) {
    //如果文件地址以”slice-“开头
    //那么将其写入到”data/data/applicationid/files/instant-run/dex“目录下
    if (patch.path.startsWith(Paths.DEX_SLICE_PREFIX)) {
        File file = FileManager.writeDexShard(patch.getBytes(), patch.path);
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Received dex shard " + file);
        }
    }
}
public class FileManager {
    public static final String CLASSES_DEX_SUFFIX = ".dex";
    private static final String FILE_NAME_ACTIVE = "active";
    private static final String FOLDER_NAME_LEFT = "left";
    private static final String FOLDER_NAME_RIGHT = "right";
    private static final String RELOAD_DEX_PREFIX = "reload";
    private static final String RESOURCE_FILE_NAME = "resources.ap_";
    private static final String RESOURCE_FOLDER_NAME = "resources";
    /***部分代码省略***/
    public static File writeDexShard(byte[] bytes, String name) {
        //创建或获取“data/data/applicationid/files/instant-run/dex”文件
        File dexFolder = getDexFileFolder(getDataFolder(), true);
        if (dexFolder == null) {
            return null;
        }
        File file = new File(dexFolder, name);
        writeRawBytes(file, bytes);
        return file;
    }
    /***部分代码省略***/
    private static File getDexFileFolder(File base, boolean createIfNecessary) {
        File file = new File(base, Paths.DEX_DIRECTORY_NAME);
        if (!createIfNecessary || file.isDirectory() || file.mkdirs()) {
            return file;
        }
        Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + file);
        return null;
    }
    private static File getDataFolder() {
        //“data/data/applicationid/files/instant-run”
        return new File(Paths.getDataDirectory(AppInfo.applicationId));
    }
}
```

![slice-.png](https://upload-images.jianshu.io/upload_images/1319879-1dc9a510ce9df174.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

当然在替换完dex之后，应用就会在重启后加载新的dex。

#### handleHotSwapPatch

```java
private int handleHotSwapPatch(int updateMode, ApplicationPatch patch) {
    if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
        Log.v(BootstrapApplication.LOG_TAG, "Received incremental code patch");
    }
    try {
        //创建data/data/applicationid/files/instant-run/dex-temp/reloadxxxx.dex文件
        String dexFile = FileManager.writeTempDexFile(patch.getBytes());
        if (dexFile == null) {
            Log.e(BootstrapApplication.LOG_TAG, "No file to write the code to");
            return updateMode;
        }
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Reading live code from " + dexFile);
        }
        //反射构造AppPatchesLoaderImpl实例
        Class<?> aClass = Class.forName("com.android.tools.fd.runtime.AppPatchesLoaderImpl", true, new DexClassLoader(dexFile, this.mApplication.getCacheDir().getPath(), FileManager.getNativeLibraryFolder().getPath(), getClass().getClassLoader()));
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Got the patcher class " + aClass);
        }
        PatchesLoader loader = (PatchesLoader) aClass.newInstance();
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Got the patcher instance " + loader);
        }
        //获取热修复所要替换的类的classname
        String[] getPatchedClasses = (String[]) aClass.getDeclaredMethod("getPatchedClasses", new Class[0]).invoke(loader, new Object[0]);
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Got the list of classes ");
            for (String getPatchedClass : getPatchedClasses) {
                Log.v(BootstrapApplication.LOG_TAG, "class " + getPatchedClass);
            }
        }
        //执行AppPatchesLoaderImpl的load方法进行类修复
        if (!loader.load()) {
            updateMode = 3;
        }
        return updateMode;
    } catch (Exception e) {
        Log.e(BootstrapApplication.LOG_TAG, "Couldn't apply code changes", e);
        e.printStackTrace();
        updateMode = 3;
    } catch (Throwable e2) {
        Log.e(BootstrapApplication.LOG_TAG, "Couldn't apply code changes", e2);
        updateMode = 3;
    }
}

public class FileManager {
    public static final String CLASSES_DEX_SUFFIX = ".dex";
    private static final String FILE_NAME_ACTIVE = "active";
    private static final String FOLDER_NAME_LEFT = "left";
    private static final String FOLDER_NAME_RIGHT = "right";
    private static final String RELOAD_DEX_PREFIX = "reload";
    private static final String RESOURCE_FILE_NAME = "resources.ap_";
    private static final String RESOURCE_FOLDER_NAME = "resources";
    /***部分代码省略***/
    public static String writeTempDexFile(byte[] bytes) {
        File file = getTempDexFile();
        if (file != null) {
            writeRawBytes(file, bytes);
            return file.getPath();
        }
        Log.e(BootstrapApplication.LOG_TAG, "No file to write temp dex content to");
        return null;
    }
    /***部分代码省略***/
    public static File getTempDexFile() {
        //“data/data/applicationid/files/instant-run”
        File dataFolder = getDataFolder();
        //“data/data/applicationid/files/instant-run/dex-temp”
        File dexFolder = getTempDexFileFolder(dataFolder);
        if (dexFolder.exists()) {
            if (!sHavePurgedTempDexFolder) {
                //删除之前的
                purgeTempDexFiles(dataFolder);
            }
        } else if (dexFolder.mkdirs()) {
            sHavePurgedTempDexFolder = true;
        } else {
            Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + dexFolder);
            return null;
        }
        File[] files = dexFolder.listFiles();
        int max = -1;
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                //文件以“reload"开头，以".dex"结尾
                if (name.startsWith(RELOAD_DEX_PREFIX) && name.endsWith(CLASSES_DEX_SUFFIX)) {
                    try {
                        //获取中间版本，取最高版本
                        int version = Integer.decode(name.substring(RELOAD_DEX_PREFIX.length(), name.length() - CLASSES_DEX_SUFFIX.length())).intValue();
                        if (version > max) {
                            max = version;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        //创建版本号+1的reloadxxx.dex文件
        File file2 = new File(dexFolder, String.format("%s0x%04x%s", new Object[]{RELOAD_DEX_PREFIX, Integer.valueOf(max + 1), CLASSES_DEX_SUFFIX}));
        if (!Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            return file2;
        }
        Log.v(BootstrapApplication.LOG_TAG, "Writing new dex file: " + file2);
        return file2;
    }
}
```

![reloadxxx.dex.png](https://upload-images.jianshu.io/upload_images/1319879-ae7247613c2cf6d4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![reload0x0000-dex2jar.png](https://upload-images.jianshu.io/upload_images/1319879-7c628a81f9b5df76.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

我们在写入完 `reload0x0000.dex` 文件后，执行 `AppPatchesLoaderImpl` 的 `load` 方法。

```java
public abstract class AbstractPatchesLoaderImpl implements PatchesLoader {
    public abstract String[] getPatchedClasses();

    public boolean load() {
        try {
            //调用getPatchedClasses，获取需要修复的classname
            for (String className : getPatchedClasses()) {
                //反射机制，构造出用来修复的类，类为classname+$override
                ClassLoader cl = getClass().getClassLoader();
                Object o = cl.loadClass(className + "$override").newInstance();
                //读取需要修复的类的$change字段
                Field changeField = cl.loadClass(className).getDeclaredField("$change");
                changeField.setAccessible(true);
                Object previous = changeField.get(null);
                if (previous != null) {
                    Field isObsolete = previous.getClass().getDeclaredField("$obsolete");
                    if (isObsolete != null) {
                        isObsolete.set(null, Boolean.valueOf(true));
                    }
                }
                //将构造出用来修复的类(classname$override),赋值给需要修复类的$change成员变量
                changeField.set(null, o);
                if (Log.logging != null && Log.logging.isLoggable(Level.FINE)) {
                    Log.logging.log(Level.FINE, String.format("patched %s", new Object[]{className}));
                }
            }
            return true;
        } catch (Exception e) {
            if (Log.logging != null) {
                Log.logging.log(Level.SEVERE, String.format("Exception while patching %s", new Object[]{"foo.bar"}), e);
            }
            return false;
        }
    }
}
```

在前面 **<u>反编译结果-java类的修改</u>** 部分中我们讲到了每个类中都有的 `IncrementalChange` 类型的 `$change` 字段。

在第一次运行的时候 `$change` 的值都是 `null` 。

先用 `InstantRunActivity$1$override` 来举个例子， `InstantRunActivity$1$override`  是 `Activity` 中的一个 `Button` 的点击事件处理类，即：`View.OnClickListener` 。

```java
public class InstantRunActivity$1$override
  implements IncrementalChange{
  public static Object init$args(InstantRunActivity.1[] paramArrayOf1, InstantRunActivity paramInstantRunActivity, Object[] paramArrayOfObject){
    return new Object[] { { paramArrayOf1, paramInstantRunActivity, new Object[0] }, "java/lang/Object.()V" };
  }
  
  public static void init$body(InstantRunActivity.1 param1, InstantRunActivity paramInstantRunActivity, Object[] paramArrayOfObject) {}
  //第一个参数为OnClickListern持有的Activity的成员变量
  public static void onClick(InstantRunActivity.1 param1, View paramView){
    Log.d("xxxxxx", "" + InstantRunActivity.access$008((InstantRunActivity)AndroidInstantRuntime.getPrivateField(param1, InstantRunActivity.1.class, "this$0")) * 2);
    InstantRunActivity.access$100((InstantRunActivity)AndroidInstantRuntime.getPrivateField(param1, InstantRunActivity.1.class, "this$0"));
  }
  //分发事件
  public Object access$dispatch(String paramString, Object... paramVarArgs){
    switch (paramString.hashCode()){
    default: 
      throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), "com/example/tzx/changeskin/InstantRunActivity$1" }));
    case -1912803358: //执行修改后的onClick方法
      onClick((InstantRunActivity.1)paramVarArgs[0], (View)paramVarArgs[1]);
      return null;
    case -451173209: 
      init$body((InstantRunActivity.1)paramVarArgs[0], (InstantRunActivity)paramVarArgs[1], (Object[])paramVarArgs[2]);
      return null;
    }
    return init$args((InstantRunActivity.1[])paramVarArgs[0], (InstantRunActivity)paramVarArgs[1], (Object[])paramVarArgs[2]);
  }
}
```

就这样通过动态的修改 `$change` 的值，在运行的过程改变函数的调用逻辑，实现内容的修复。 

#### handleResourcePatch

```java
private static int handleResourcePatch(int updateMode, ApplicationPatch patch, String path) {
    if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
        Log.v(BootstrapApplication.LOG_TAG, "Received resource changes (" + path + ")");
    }
    FileManager.writeAaptResources(path, patch.getBytes());
    return Math.max(updateMode, 2);
}
```

### Restart

一般通过现象看本质，而通过程序的运行判断修复的类型却不一定是正确的。

![on-code-change.png](https://upload-images.jianshu.io/upload_images/1319879-cad075fe9c2ea6f6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

比如在 `AndroidStudio` 的 `Instant Run` 选项中勾选了 `Restart activity on code changes` 的话，无论什么样的类型修复都至少会重启当前的 `Activity` 。

下边列举我实际测试的结果：

- 修改java方法的代码

```java
I/Toast: Show toast from OpPackageName:com.tanzx.instantrun, PackageName:com.tanzx.instantrun, content:Applied code changes without activity restart
V/RenderScript: 0xa0f7d000 Launching thread(s), CPUs 4
Hot swapped changes, activity not restarted
```

- 资源文件的修改

```java
Hot swapped changes, activity restarted
I/Toast: Show toast from OpPackageName:com.tanzx.instantrun, PackageName:com.tanzx.instantrun, content:Applied changes, restarted activity
```

`AndroidStudio` 有更友好的提示：

![add_class_quote.png](https://upload-images.jianshu.io/upload_images/1319879-e2d7112964aab63d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![class_add.png](https://upload-images.jianshu.io/upload_images/1319879-fbe2913b0ffa58bf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![code_changes.png](https://upload-images.jianshu.io/upload_images/1319879-60255458580e8a68.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![field_added.png](https://upload-images.jianshu.io/upload_images/1319879-2cbe66d2a1a1e5e6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![method_add.png](https://upload-images.jianshu.io/upload_images/1319879-10e6ae27668f30bd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![R_class_changes.png](https://upload-images.jianshu.io/upload_images/1319879-9e3ff2f78634840b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![static_init_change.png](https://upload-images.jianshu.io/upload_images/1319879-1614810692a6591e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 小结

我们将以上的所有内容梳理一下：

- 修改源代码，每个类增加 `$change` 字段；

- 替换 `Application` ；
- 创建自己的类加载器，修改正常的类加载器的加载顺序；
- 开启 `Socket` 监听 `AndroidStudio` 推送的消息；
- 处理消息（热、温、冷）
  - 热：给类的 `$change` 字段赋值，改变运行逻辑；
  - 温：替换加载新的资源，重启当前 `Activity` 生效；
  - 冷：写入新的 `dex` 文件，重新加载新的 `dex`;

## Gradle2.3.0版本

### 相同点：

我们在 `gradle2.2.3` 小结中发现其实我们只是需要做到以下几点就可以进行热修复：

- 开启 `Socket` 监听 `AndroidStudio` 推送的消息；

- 处理消息：给类的 `$change` 字段赋值，改变运行逻辑；

### 不同点

`Gradle2.3.0` 在  `Gradle2.2.3` 的基础之上进行了一定的修改，那么我们接下来只对比两个版本之间的不同点：

- 去掉了 `BootstrapApplication`  替换，直接启动一个 `InstantRunService` 用来启动 `Socket` 与 `Android Studio` 进行信息传递；

AndroidManifest.xml

```xml
<application android:theme="@style/AppTheme" 
             android:label="@string/app_name" 
             android:icon="@mipmap/ic_launcher" 
             android:name="com.example.instantrun.MyApplication" 
             android:debuggable="true" 
             android:allowBackup="true" 
             android:supportsRtl="true">
    <activity android:name="com.example.instantrun.MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity>
    <service android:name="com.android.tools.fd.runtime.InstantRunService" 							android:exported="true"/>
</application>
```

InstantRunService:

```java
public class InstantRunService extends Service {
    private Server server;
	/***部分代码省略***/
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
```

- 去掉了所谓的冷启动（`handleColdSwapPatch`），需要冷启动的时候直接进行碎片安装重启不就好了；

  PS：分裂apk以及安装参考：[Android Studio 配置构建变体](https://developer.android.com/studio/build/configure-apk-splits) 

```java
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
```

### 结果

在 `Gradle2.3.0` 版本上进行试验的时候，我一直没有找到 `InstantRunService` 是怎么启动的。结果：每一次都是执行的是 `install-multiple` ，然后重新启动。

在网上找了些资料发现好多用 `Gradle2.3.0` 的朋友有相关的报错：

```shell
Launching app
$ adb shell am startservice kang.yi.zhi.tan.tanzhiyikang/com.android.tools.fd.runtime.InstantRunService
Error while executing: am startservice kang.yi.zhi.tan.tanzhiyikang/com.android.tools.fd.runtime.InstantRunService
Starting service: Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=kang.yi.zhi.tan.tanzhiyikang/com.android.tools.fd.runtime.InstantRunService }
Error: Not found; no service started.
```

从这个错误可以看处理，是 `AndroidStudio` 执行了 `adb` 命令启动了 `InstantRunService` 。

## Gralde3.0.0版本

### 相同点：

我们在 `gradle2.2.3` 和 `gralde2.3.0` 中发现其实我们只是需要做到以下几点就可以进行热修复：

- 开启 `Socket` 监听 `AndroidStudio` 推送的消息；
- 处理消息：给类的 `$change` 字段赋值，改变运行逻辑；

### 不同点

`Gradle3.0.0` 在  `Gradle2.3.0` 的基础之上进行了一定的修改，那么我们接下来只对比两个版本之间的不同点：

- 去掉了 `InstantRunService` ，而通过用 `ContentProvider` 来启动 `Socket` 与 `Android Studio` 进行信息传递，因为 `ContentProvider` 在应用启动的时候就行创建；

AndroidManifest.xml

```xml
<application android:theme="@style/AppTheme" android:label="@string/app_name" android:icon="@mipmap/ic_launcher" android:name="com.example.tzx.changeskin.MyApplication" android:debuggable="true" android:testOnly="true" android:allowBackup="true" android:supportsRtl="true">
        <activity android:name="com.example.tzx.changeskin.InstantRunActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
        <provider android:name="com.android.tools.ir.server.InstantRunContentProvider" android:multiprocess="true" android:authorities="com.example.tzx.changeskin.com.android.tools.ir.server.InstantRunContentProvider"/>
    </application>
```

InstantRunContentProvider：

```java
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
    /***部分代码省略***/
}
```

### 结果：

和预期的相同，进行部分代码修改的时候只需要重新启动当前的 `Activity` ，进行资源替换或类的结构修改的时候需要重新启动 `Application` ；否则进行新的 ``install-multiple`` 安装增量apk。

## 总结：
- `InstantRun` 相关的所有内容都讲述完了，其核心的就是在于编译时给每个类进行  `$change` 的插入，修复的时候再给类的 `$change` 赋值；
- 不同 `Gradle` 版本之间主要是触发 `Socket` 启动的姿势不同；
- 中间穿插的讲述了 `Application` 的替换、`ClassLoader` 的创建和类加载器顺序的修改。

除过以上内容外还有 `gradle` 在编译打包的时候对类文件和 
`AndroidManifest.xml` 的修改，以及每次使用 `instant-run` 时差异包的生产、下发和处理都是我们做插件化或者热修复可以借鉴和学习的。


文章到这里就全部讲述完啦，若有其他需要交流的可以留言哦~！~！

想阅读作者的更多文章，可以查看我 [个人博客](http://dandanlove.com/) 和公共号：
![振兴书城](http://upload-images.jianshu.io/upload_images/1319879-612c4c66d40ce855.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
=======
# InstantRun-ApkParse
apk parse files that about instant-run 
>>>>>>> 04ee01ec0cca62da96ee2e11ca4ba40be7dd8428
