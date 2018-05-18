package com.android.tools.ir.runtime;

public class PatchesLoaderDumper {
    public static void main(String[] args) {
        try {
            ((PatchesLoader) Class.forName("com.android.tools.ir.runtime.AppPatchesLoaderImpl").newInstance()).load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
