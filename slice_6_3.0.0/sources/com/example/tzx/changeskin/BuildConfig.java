package com.example.tzx.changeskin;

import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public final class BuildConfig {
    public static volatile transient /* synthetic */ IncrementalChange $change = null;
    public static final String APPLICATION_ID = "com.example.tzx.changeskin";
    public static final String BUILD_TYPE = "debug";
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";
    public static final long serialVersionUID = -929561198012010761L;

    BuildConfig(Object[] objArr, InstantReloadException instantReloadException) {
        switch (((String) objArr[1]).hashCode()) {
            case -1968665286:
                return;
            case -194904603:
                this();
                return;
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "com/example/tzx/changeskin/BuildConfig"}));
        }
    }

    public static /* synthetic */ Object access$super(BuildConfig buildConfig, String str, Object... objArr) {
        switch (str.hashCode()) {
            case -2128160755:
                return super.toString();
            case -1554832987:
                super.finalize();
                return null;
            case -1021472056:
                super.wait(((Number) objArr[0]).longValue());
                return null;
            case 201261558:
                return super.getClass();
            case 1403628309:
                return new Integer(super.hashCode());
            case 1814730534:
                return new Boolean(super.equals(objArr[0]));
            case 2025021518:
                return super.clone();
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "com/example/tzx/changeskin/BuildConfig"}));
        }
    }

    public BuildConfig() {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Lcom/example/tzx/changeskin/BuildConfig;[Ljava/lang/Object;)Ljava/lang/Object;", new Object[]{null, new Object[0]});
            Object[] objArr2 = (Object[]) objArr[0];
            this(objArr, null);
            objArr2[0] = this;
            incrementalChange.access$dispatch("init$body.(Lcom/example/tzx/changeskin/BuildConfig;[Ljava/lang/Object;)V", objArr2);
        }
    }
}
