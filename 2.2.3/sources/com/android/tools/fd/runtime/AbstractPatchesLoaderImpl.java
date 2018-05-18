package com.android.tools.fd.runtime;

import com.android.tools.fd.common.Log;
import java.lang.reflect.Field;
import java.util.logging.Level;

public abstract class AbstractPatchesLoaderImpl implements PatchesLoader {
    public abstract String[] getPatchedClasses();

    public boolean load() {
        try {
            for (String className : getPatchedClasses()) {
                ClassLoader cl = getClass().getClassLoader();
                Object o = cl.loadClass(className + "$override").newInstance();
                Field changeField = cl.loadClass(className).getDeclaredField("$change");
                changeField.setAccessible(true);
                Object previous = changeField.get(null);
                if (previous != null) {
                    Field isObsolete = previous.getClass().getDeclaredField("$obsolete");
                    if (isObsolete != null) {
                        isObsolete.set(null, Boolean.valueOf(true));
                    }
                }
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
