package com.orcanote.boilerplate.domain.interactor;

import com.orcanote.boilerplate.domain.executor.BackgroundExecutor;
import com.orcanote.boilerplate.domain.executor.MainExecutor;

public abstract class BackgroundInteractor implements Interactor {

    protected MainExecutor       mMainExecutor;
    protected BackgroundExecutor mBackgroundExecutor;

    protected BackgroundInteractor(MainExecutor mainExecutor,
                                   BackgroundExecutor backgroundExecutor) {
        mMainExecutor = mainExecutor;
        mBackgroundExecutor = backgroundExecutor;
    }

    public abstract void run();

    @Override
    public void execute() {
        mBackgroundExecutor.execute(this);
    }
}
