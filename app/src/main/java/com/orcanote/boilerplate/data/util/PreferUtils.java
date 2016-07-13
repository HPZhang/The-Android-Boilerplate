package com.orcanote.boilerplate.data.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.orcanote.boilerplate.AndroidApplication;

/**
 * @author orcanote
 */
public class PreferUtils {
    public static final String FILE_NAME = "com.orcanote.prefer";

    private PreferUtils() {
    }

    public static void set(String fileName, String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences(fileName).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String fileName, String key) {
        return sharedPreferences(fileName).getString(key, null);
    }

    public static void remove(String fileName, String key) {
        sharedPreferences(fileName).edit().remove(key).apply();
    }

    public static void clear(String fileName) {
        sharedPreferences(fileName).edit().clear().apply();
    }

    private static SharedPreferences sharedPreferences(String fileName) {
        return AndroidApplication.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }
}
