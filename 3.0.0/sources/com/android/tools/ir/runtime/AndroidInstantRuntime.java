package com.android.tools.ir.runtime;

import com.android.tools.ir.common.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidInstantRuntime {

    protected interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }

    public static void setLogger(final Logger logger) {
        Log.logging = new com.android.tools.ir.common.Log.Logging() {
            public void log(Level level, String string) {
                logger.log(level, string);
            }

            public boolean isLoggable(Level level) {
                return logger.isLoggable(level);
            }

            public void log(Level level, String string, Throwable throwable) {
                logger.log(level, string, throwable);
            }
        };
    }

    public static Object getStaticPrivateField(Class targetClass, String fieldName) {
        return getPrivateField(null, targetClass, fieldName);
    }

    public static void setStaticPrivateField(Object value, Class targetClass, String fieldName) {
        setPrivateField(null, value, targetClass, fieldName);
    }

    public static void setPrivateField(Object targetObject, Object value, Class targetClass, String fieldName) {
        try {
            getField(targetClass, fieldName).set(targetObject, value);
        } catch (IllegalAccessException e) {
            if (Log.logging != null) {
                Log.logging.log(Level.SEVERE, String.format("Exception during setPrivateField %s", new Object[]{fieldName}), e);
            }
            throw new RuntimeException(e);
        }
    }

    public static Object getPrivateField(Object targetObject, Class targetClass, String fieldName) {
        try {
            return getField(targetClass, fieldName).get(targetObject);
        } catch (IllegalAccessException e) {
            if (Log.logging != null) {
                com.android.tools.ir.common.Log.Logging logging = Log.logging;
                Level level = Level.SEVERE;
                String str = "Exception during%1$s getField %2$s";
                Object[] objArr = new Object[2];
                objArr[0] = targetObject == null ? " static" : "";
                objArr[1] = fieldName;
                logging.log(level, String.format(str, objArr), e);
            }
            throw new RuntimeException(e);
        }
    }

    private static Field getField(Class target, String name) {
        Field declareField = getFieldByName(target, name);
        if (declareField == null) {
            throw new RuntimeException(new NoSuchElementException(name));
        }
        declareField.setAccessible(true);
        return declareField;
    }

    public static Object invokeProtectedMethod(Object receiver, Object[] params, Class[] parameterTypes, String methodName) throws Throwable {
        if (Log.logging != null && Log.logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("protectedMethod:%s on %s", new Object[]{methodName, receiver}));
        }
        try {
            Method toDispatchTo = getMethodByName(receiver.getClass(), methodName, parameterTypes);
            if (toDispatchTo == null) {
                throw new RuntimeException(new NoSuchMethodException(methodName));
            }
            toDispatchTo.setAccessible(true);
            return toDispatchTo.invoke(receiver, params);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        } catch (IllegalAccessException e2) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", new Object[]{methodName}), e2);
            throw new RuntimeException(e2);
        }
    }

    public static Object invokeProtectedStaticMethod(Object[] params, Class[] parameterTypes, String methodName, Class receiverClass) throws Throwable {
        if (Log.logging != null && Log.logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("protectedStaticMethod:%s on %s", new Object[]{methodName, receiverClass.getName()}));
        }
        try {
            Method toDispatchTo = getMethodByName(receiverClass, methodName, parameterTypes);
            if (toDispatchTo == null) {
                throw new RuntimeException(new NoSuchMethodException(methodName + " in class " + receiverClass.getName()));
            }
            toDispatchTo.setAccessible(true);
            return toDispatchTo.invoke(null, params);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        } catch (IllegalAccessException e2) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", new Object[]{methodName}), e2);
            throw new RuntimeException(e2);
        }
    }

    public static <T> T newForClass(Object[] params, Class[] paramTypes, Class<T> targetClass) throws Throwable {
        try {
            Constructor declaredConstructor = targetClass.getDeclaredConstructor(paramTypes);
            declaredConstructor.setAccessible(true);
            try {
                return targetClass.cast(declaredConstructor.newInstance(params));
            } catch (InvocationTargetException e) {
                throw e.getCause();
            } catch (InstantiationException e2) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", new Object[]{targetClass}), e2);
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", new Object[]{targetClass}), e3);
                throw new RuntimeException(e3);
            }
        } catch (NoSuchMethodException e4) {
            Log.logging.log(Level.SEVERE, "Exception while resolving constructor", e4);
            throw new RuntimeException(e4);
        }
    }

    private static Field getFieldByName(Class<?> aClass, String name) {
        if (Log.logging != null && Log.logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("getFieldByName:%s in %s", new Object[]{name, aClass.getName()}));
        }
        Class<?> currentClass = aClass;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        return null;
    }

    private static Method getMethodByName(Class<?> aClass, String name, Class[] paramTypes) {
        Method method = null;
        if (aClass != null) {
            Class<?> currentClass = aClass;
            while (currentClass != null) {
                try {
                    method = currentClass.getDeclaredMethod(name, paramTypes);
                    break;
                } catch (NoSuchMethodException e) {
                    currentClass = currentClass.getSuperclass();
                    if (!(currentClass == null || Log.logging == null || !Log.logging.isLoggable(Level.FINE))) {
                        Log.logging.log(Level.FINE, String.format("getMethodByName:Looking in %s now", new Object[]{currentClass.getName()}));
                    }
                }
            }
        }
        return method;
    }

    public static void trace(String s) {
        if (Log.logging != null) {
            Log.logging.log(Level.FINE, s);
        }
    }

    public static void trace(String s1, String s2) {
        if (Log.logging != null) {
            Log.logging.log(Level.FINE, String.format("%s %s", new Object[]{s1, s2}));
        }
    }

    public static void trace(String s1, String s2, String s3) {
        if (Log.logging != null) {
            Log.logging.log(Level.FINE, String.format("%s %s %s", new Object[]{s1, s2, s3}));
        }
    }

    public static void trace(String s1, String s2, String s3, String s4) {
        if (Log.logging != null) {
            Log.logging.log(Level.FINE, String.format("%s %s %s %s", new Object[]{s1, s2, s3, s4}));
        }
    }
}
