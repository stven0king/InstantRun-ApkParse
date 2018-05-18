package com.example.tzx.changeskin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import com.android.tools.ir.runtime.AndroidInstantRuntime;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import java.lang.reflect.Field;

public class InstantRunActivity$override
  implements IncrementalChange
{
  public static void change(InstantRunActivity paramInstantRunActivity)
  {
    try
    {
      paramInstantRunActivity = InstantRunActivity.class.getDeclaredFields();
      int j = paramInstantRunActivity.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramInstantRunActivity[i];
        ((Field)localObject).setAccessible(true);
        Log.d("tanzhenxing", ((Field)localObject).getName() + ((Field)localObject).getModifiers());
        i += 1;
      }
      return;
    }
    catch (Exception paramInstantRunActivity)
    {
      paramInstantRunActivity.printStackTrace();
    }
  }
  
  public static Object init$args(InstantRunActivity[] paramArrayOfInstantRunActivity, Object[] paramArrayOfObject)
  {
    return new Object[] { { paramArrayOfInstantRunActivity, new Object[0] }, "android/support/v7/app/AppCompatActivity.()V" };
  }
  
  public static void init$body(InstantRunActivity paramInstantRunActivity, Object[] paramArrayOfObject) {}
  
  public static void onCreate(@Nullable InstantRunActivity paramInstantRunActivity, Bundle paramBundle)
  {
    InstantRunActivity.access$super(paramInstantRunActivity, "onCreate.(Landroid/os/Bundle;)V", new Object[] { paramBundle });
    paramInstantRunActivity.setContentView(2131296281);
    AndroidInstantRuntime.setPrivateField(paramInstantRunActivity, paramInstantRunActivity, InstantRunActivity.class, "context");
    AndroidInstantRuntime.setPrivateField(paramInstantRunActivity, (Button)paramInstantRunActivity.findViewById(2131165205), InstantRunActivity.class, "button");
    ((Button)AndroidInstantRuntime.getPrivateField(paramInstantRunActivity, InstantRunActivity.class, "button")).setOnClickListener((InstantRunActivity.1)AndroidInstantRuntime.newForClass(new Object[] { paramInstantRunActivity }, new Class[] { InstantRunActivity.class }, InstantRunActivity.1.class));
  }
  
  public static int static$access$008(InstantRunActivity paramInstantRunActivity)
  {
    int i = ((Number)AndroidInstantRuntime.getPrivateField(paramInstantRunActivity, InstantRunActivity.class, "num")).intValue();
    AndroidInstantRuntime.setPrivateField(paramInstantRunActivity, new Integer(i + 1), InstantRunActivity.class, "num");
    return i;
  }
  
  public static void static$access$100(InstantRunActivity paramInstantRunActivity)
  {
    change(paramInstantRunActivity);
  }
  
  public Object access$dispatch(String paramString, Object... paramVarArgs)
  {
    switch (paramString.hashCode())
    {
    default: 
      throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), "com/example/tzx/changeskin/InstantRunActivity" }));
    case -2133114825: 
      change((InstantRunActivity)paramVarArgs[0]);
      return null;
    case -1483426920: 
      init$body((InstantRunActivity)paramVarArgs[0], (Object[])paramVarArgs[1]);
      return null;
    case -842860182: 
      return new Integer(static$access$008((InstantRunActivity)paramVarArgs[0]));
    case -641568046: 
      onCreate((InstantRunActivity)paramVarArgs[0], (Bundle)paramVarArgs[1]);
      return null;
    case -500374726: 
      return init$args((InstantRunActivity[])paramVarArgs[0], (Object[])paramVarArgs[1]);
    }
    static$access$100((InstantRunActivity)paramVarArgs[0]);
    return null;
  }
}


/* Location:              /Users/tanzx/Note/随笔/Hotfix/apk-parse/reload0x0000-dex2jar.jar!/com/example/tzx/changeskin/InstantRunActivity$override.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */