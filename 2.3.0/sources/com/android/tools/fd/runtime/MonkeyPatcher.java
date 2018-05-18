package com.android.tools.fd.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;

public class MonkeyPatcher {
    public static Object getActivityThread(Context context, Class<?> activityThread) {
        if (activityThread == null) {
            try {
                activityThread = Class.forName("android.app.ActivityThread");
            } catch (Throwable th) {
                return null;
            }
        }
        Method m = activityThread.getMethod("currentActivityThread", new Class[0]);
        m.setAccessible(true);
        Object currentActivityThread = m.invoke(null, new Object[0]);
        if (currentActivityThread != null || context == null) {
            return currentActivityThread;
        }
        Field mLoadedApk = context.getClass().getField("mLoadedApk");
        mLoadedApk.setAccessible(true);
        Object apk = mLoadedApk.get(context);
        Field mActivityThreadField = apk.getClass().getDeclaredField("mActivityThread");
        mActivityThreadField.setAccessible(true);
        return mActivityThreadField.get(apk);
    }

    public static void monkeyPatchExistingResources(Context context, String externalResourceFile, Collection<Activity> activities) {
        Field mResourcesImpl;
        Object resourceImpl;
        Field implAssets;
        if (externalResourceFile != null) {
            AssetManager newAssetManager = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method mAddAssetPath = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[]{String.class});
            mAddAssetPath.setAccessible(true);
            if (((Integer) mAddAssetPath.invoke(newAssetManager, new Object[]{externalResourceFile})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            Resources resources;
            Field mAssets;
            Method mEnsureStringBlocks = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
            mEnsureStringBlocks.setAccessible(true);
            mEnsureStringBlocks.invoke(newAssetManager, new Object[0]);
            if (activities != null) {
                for (Activity activity : activities) {
                    resources = activity.getResources();
                    try {
                        mAssets = Resources.class.getDeclaredField("mAssets");
                        mAssets.setAccessible(true);
                        mAssets.set(resources, newAssetManager);
                    } catch (Throwable e) {
                        IllegalStateException illegalStateException = new IllegalStateException(e);
                    }
                    Theme theme = activity.getTheme();
                    Field ma;
                    try {
                        ma = Theme.class.getDeclaredField("mAssets");
                        ma.setAccessible(true);
                        ma.set(theme, newAssetManager);
                    } catch (NoSuchFieldException e2) {
                        Field themeField = Theme.class.getDeclaredField("mThemeImpl");
                        themeField.setAccessible(true);
                        Object impl = themeField.get(theme);
                        ma = impl.getClass().getDeclaredField("mAssets");
                        ma.setAccessible(true);
                        ma.set(impl, newAssetManager);
                    } catch (Throwable e3) {
                        Log.e(Logging.LOG_TAG, "Failed to update existing theme for activity " + activity, e3);
                    }
                    Field mt = ContextThemeWrapper.class.getDeclaredField("mTheme");
                    mt.setAccessible(true);
                    mt.set(activity, null);
                    Method mtm = ContextThemeWrapper.class.getDeclaredMethod("initializeTheme", new Class[0]);
                    mtm.setAccessible(true);
                    mtm.invoke(activity, new Object[0]);
                    if (VERSION.SDK_INT < 24) {
                        Method mCreateTheme = AssetManager.class.getDeclaredMethod("createTheme", new Class[0]);
                        mCreateTheme.setAccessible(true);
                        Object internalTheme = mCreateTheme.invoke(newAssetManager, new Object[0]);
                        Field mTheme = Theme.class.getDeclaredField("mTheme");
                        mTheme.setAccessible(true);
                        mTheme.set(theme, internalTheme);
                    }
                    pruneResourceCaches(resources);
                }
            }
            Field fMActiveResources;
            Collection<WeakReference<Resources>> references;
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
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
        }
    }

    private static void pruneResourceCaches(Object resources) {
        if (VERSION.SDK_INT >= 21) {
            try {
                Field typedArrayPoolField = Resources.class.getDeclaredField("mTypedArrayPool");
                typedArrayPoolField.setAccessible(true);
                Object pool = typedArrayPoolField.get(resources);
                Method acquireMethod = pool.getClass().getDeclaredMethod("acquire", new Class[0]);
                acquireMethod.setAccessible(true);
                do {
                } while (acquireMethod.invoke(pool, new Object[0]) != null);
            } catch (Throwable th) {
            }
        }
        if (VERSION.SDK_INT >= 23) {
            try {
                Field mResourcesImpl = Resources.class.getDeclaredField("mResourcesImpl");
                mResourcesImpl.setAccessible(true);
                resources = mResourcesImpl.get(resources);
            } catch (Throwable th2) {
            }
        }
        Object lock = null;
        Field field;
        if (VERSION.SDK_INT >= 18) {
            try {
                field = resources.getClass().getDeclaredField("mAccessLock");
                field.setAccessible(true);
                lock = field.get(resources);
            } catch (Throwable th3) {
            }
        } else {
            try {
                field = Resources.class.getDeclaredField("mTmpValue");
                field.setAccessible(true);
                lock = field.get(resources);
            } catch (Throwable th4) {
            }
        }
        if (lock == null) {
            lock = MonkeyPatcher.class;
        }
        synchronized (lock) {
            pruneResourceCache(resources, "mDrawableCache");
            pruneResourceCache(resources, "mColorDrawableCache");
            pruneResourceCache(resources, "mColorStateListCache");
            if (VERSION.SDK_INT >= 23) {
                pruneResourceCache(resources, "mAnimatorCache");
                pruneResourceCache(resources, "mStateListAnimatorCache");
            } else if (VERSION.SDK_INT == 19) {
                pruneResourceCache(resources, "sPreloadedDrawables");
                pruneResourceCache(resources, "sPreloadedColorDrawables");
                pruneResourceCache(resources, "sPreloadedColorStateLists");
            }
        }
    }

    private static boolean pruneResourceCache(Object resources, String fieldName) {
        Field cacheField;
        try {
            cacheField = resources.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            cacheField = Resources.class.getDeclaredField(fieldName);
        } catch (Throwable th) {
        }
        cacheField.setAccessible(true);
        Object cache = cacheField.get(resources);
        Class<?> type = cacheField.getType();
        if (VERSION.SDK_INT < 16) {
            if (cache instanceof SparseArray) {
                ((SparseArray) cache).clear();
                return true;
            } else if (VERSION.SDK_INT >= 14 && (cache instanceof LongSparseArray)) {
                ((LongSparseArray) cache).clear();
                return true;
            }
        } else if (VERSION.SDK_INT >= 23) {
            while (type != null) {
                try {
                    Method configChangeMethod = type.getDeclaredMethod("onConfigurationChange", new Class[]{Integer.TYPE});
                    configChangeMethod.setAccessible(true);
                    configChangeMethod.invoke(cache, new Object[]{Integer.valueOf(-1)});
                    return true;
                } catch (Throwable th2) {
                    type = type.getSuperclass();
                }
            }
        } else if ("mColorStateListCache".equals(fieldName)) {
            if (cache instanceof LongSparseArray) {
                ((LongSparseArray) cache).clear();
            }
        } else if (type.isAssignableFrom(ArrayMap.class)) {
            Method clearArrayMap = Resources.class.getDeclaredMethod("clearDrawableCachesLocked", new Class[]{ArrayMap.class, Integer.TYPE});
            clearArrayMap.setAccessible(true);
            clearArrayMap.invoke(resources, new Object[]{cache, Integer.valueOf(-1)});
            return true;
        } else if (type.isAssignableFrom(LongSparseArray.class)) {
            try {
                Method clearSparseMap = Resources.class.getDeclaredMethod("clearDrawableCachesLocked", new Class[]{LongSparseArray.class, Integer.TYPE});
                clearSparseMap.setAccessible(true);
                clearSparseMap.invoke(resources, new Object[]{cache, Integer.valueOf(-1)});
                return true;
            } catch (NoSuchMethodException e2) {
                if (cache instanceof LongSparseArray) {
                    ((LongSparseArray) cache).clear();
                    return true;
                }
            }
        } else if (type.isArray() && type.getComponentType().isAssignableFrom(LongSparseArray.class)) {
            for (LongSparseArray array : (LongSparseArray[]) cache) {
                if (array != null) {
                    array.clear();
                }
            }
            return true;
        }
        return false;
    }
}
