package com.android.tools.fd.runtime;

import com.android.tools.fd.common.Log;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ApplicationPatch {
    public final byte[] data;
    public final String path;

    public ApplicationPatch(String path, byte[] data) {
        this.path = path;
        this.data = data;
    }

    public String toString() {
        return "ApplicationPatch{path='" + this.path + '\'' + ", data.length='" + this.data.length + '\'' + '}';
    }

    public static List<ApplicationPatch> read(DataInputStream input) throws IOException {
        //从流里面读一个指定长度为Integer(4个字节)的数字
        int changeCount = input.readInt();
        if (Log.logging != null && Log.logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, "Receiving " + changeCount + " changes");
        }
        List<ApplicationPatch> changes = new ArrayList(changeCount);
        for (int i = 0; i < changeCount; i++) {
            //从流里面读一个指定长度的UTF-8编码的字符串
            String path = input.readUTF();
            byte[] bytes = new byte[input.readInt()];
            input.readFully(bytes);
            changes.add(new ApplicationPatch(path, bytes));
        }
        return changes;
    }

    public String getPath() {
        return this.path;
    }

    public byte[] getBytes() {
        return this.data;
    }
}
