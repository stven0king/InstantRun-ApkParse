package com.example.tzx.changeskin;

import android.util.Log;
import android.view.View;
import com.android.tools.ir.runtime.AndroidInstantRuntime;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class InstantRunActivity$1$override
  implements IncrementalChange
{
  public static Object init$args(InstantRunActivity.1[] paramArrayOf1, InstantRunActivity paramInstantRunActivity, Object[] paramArrayOfObject)
  {
    return new Object[] { { paramArrayOf1, paramInstantRunActivity, new Object[0] }, "java/lang/Object.()V" };
  }
  
  public static void init$body(InstantRunActivity.1 param1, InstantRunActivity paramInstantRunActivity, Object[] paramArrayOfObject) {}
  
  public static void onClick(InstantRunActivity.1 param1, View paramView)
  {
    Log.d("tanzhenxing", "" + InstantRunActivity.access$008((InstantRunActivity)AndroidInstantRuntime.getPrivateField(param1, InstantRunActivity.1.class, "this$0")) * 2);
    InstantRunActivity.access$100((InstantRunActivity)AndroidInstantRuntime.getPrivateField(param1, InstantRunActivity.1.class, "this$0"));
  }
  
  public Object access$dispatch(String paramString, Object... paramVarArgs)
  {
    switch (paramString.hashCode())
    {
    default: 
      throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), "com/example/tzx/changeskin/InstantRunActivity$1" }));
    case -1912803358: 
      onClick((InstantRunActivity.1)paramVarArgs[0], (View)paramVarArgs[1]);
      return null;
    case -451173209: 
      init$body((InstantRunActivity.1)paramVarArgs[0], (InstantRunActivity)paramVarArgs[1], (Object[])paramVarArgs[2]);
      return null;
    }
    return init$args((InstantRunActivity.1[])paramVarArgs[0], (InstantRunActivity)paramVarArgs[1], (Object[])paramVarArgs[2]);
  }
}


/* Location:              /Users/tanzx/Note/随笔/Hotfix/apk-parse/reload0x0000-dex2jar.jar!/com/example/tzx/changeskin/InstantRunActivity$1$override.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */