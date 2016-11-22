package com.orcanote.boilerplate.storage.data;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * decouple AndroidApplication
 * make data layer being dependent on Android Context.
 */
@SuppressLint("StaticFieldLeak")
public class ContextHolder {

    private static volatile ContextHolder mContextHolder;
    private                 Context       mContext;

    private ContextHolder() {
        //no instance
    }

    public static void inject(Context context) {
        if (mContextHolder == null) {
            mContextHolder = new ContextHolder();
            mContextHolder.mContext = context;
        }
    }

    public static Context getApplicationContext() {
        if (mContextHolder == null) {
            throw new NullPointerException("Must inject context before using.");
        }

        return mContextHolder.mContext.getApplicationContext();
    }
}
