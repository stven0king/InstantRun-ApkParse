package com.android.tools.ir.common;

import java.util.logging.Level;

public class Log {
    public static Logging logging = null;

    public interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }
}
