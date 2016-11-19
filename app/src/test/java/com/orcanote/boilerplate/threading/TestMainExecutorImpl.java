package com.orcanote.boilerplate.threading;

import com.orcanote.boilerplate.domain.executor.MainExecutor;

public class TestMainExecutorImpl implements MainExecutor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
