package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.executor.BackgroundExecutor;
import com.orcanote.boilerplate.domain.executor.MainExecutor;
import com.orcanote.boilerplate.domain.interactor.BackgroundInteractor;

public class BackgroundInteractorImpl extends BackgroundInteractor {

    private Callback mCallback;

    public BackgroundInteractorImpl(MainExecutor mainExecutor,
                                    BackgroundExecutor backgroundExecutor,
                                    Callback callback) {
        super(mainExecutor, backgroundExecutor);

        mCallback = callback;
    }

    @Override
    public void run() {
        mMainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCallback.onBackgroundInteractorCompleted("This is a background interactor!");

                mCallback = null;
                mMainExecutor = null;
                mBackgroundExecutor = null;
            }
        });
    }

    public interface Callback {

        void onBackgroundInteractorCompleted(String message);
    }
}
