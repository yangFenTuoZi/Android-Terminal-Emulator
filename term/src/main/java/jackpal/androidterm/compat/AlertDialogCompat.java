package jackpal.androidterm.compat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogCompat extends AlertDialog
{
  // API 11
  public static int THEME_HOLO_TRADITIONAL=      1;
  public static int THEME_HOLO_DARK=             2;
  public static int THEME_HOLO_LIGHT=            3;
  // API 14
  public static int THEME_DEVICE_DEFAULT_DARK=   4;
  public static int THEME_DEVICE_DEFAULT_LIGHT=  5;
  ////////////////////////////////////////////////////////////
  private AlertDialogCompat(Context context)
  {
    super(context);
  }
  private AlertDialogCompat(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
  {
    super(context, cancelable, cancelListener);
  }
  ////////////////////////////////////////////////////////////
  private static class Api14OrLater extends AlertDialog
  {
    public Api14OrLater(Context context, int theme)
    {
      super(context, theme);
    }
  }
  ////////////////////////////////////////////////////////////
  public static AlertDialog newInstance(Context context)
  {
    return(new AlertDialogCompat(context));
  }
  ////////////////////////////////////////////////////////////
  public static AlertDialog newInstance(Context context, int theme)
  {
    return(new Api14OrLater(context, theme));
  }
  ////////////////////////////////////////////////////////////
  public static AlertDialog newInstance(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
  {
    return(new AlertDialogCompat(context, cancelable, cancelListener));
  }
  ////////////////////////////////////////////////////////////

  public static AlertDialog.Builder newInstanceBuilder(Context context, int theme) {
    return new AlertDialog.Builder(context);
  }
}
