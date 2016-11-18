package com.orcanote.boilerplate.threading;

import android.os.Handler;
import android.os.Looper;

import com.orcanote.boilerplate.domain.executor.MainExecutor;

public class MainExecutorImpl implements MainExecutor {

    private static MainExecutorImpl sMainExecutorImpl;

    private Handler mHandler;

    private MainExecutorImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static MainExecutorImpl getInstance() {
        if (sMainExecutorImpl == null) {
            sMainExecutorImpl = new MainExecutorImpl();
        }

        return sMainExecutorImpl;
    }

    @Override
    public void execute(Runnable runnable) {
        mHandler.post(runnable);
    }
}
