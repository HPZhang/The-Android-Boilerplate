package com.orcanote.boilerplate.ui.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast
 * @author orcanote
 */
public class ToastUtils {

  private ToastUtils() {
  }

  public static void showError(Context context, String message) {
    getToast(context, message).show();
  }

  public static void showShortMessage(Context context, String message) {
    getToast(context, message, Toast.LENGTH_SHORT).show();
  }

  private static Toast getToast(Context context, String message) {
    return getToast(context, message, Toast.LENGTH_LONG);
  }

  private static Toast getToast(Context context, String message, int length) {
    return Toast.makeText(context, message, length);
  }
}
