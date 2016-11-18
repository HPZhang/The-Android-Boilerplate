package com.orcanote.boilerplate.threading;

import com.orcanote.boilerplate.domain.executor.BackgroundExecutor;
import com.orcanote.boilerplate.domain.interactor.BackgroundInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackgroundExecutorImpl implements BackgroundExecutor {
    
    private static volatile BackgroundExecutorImpl sBackgroundExecutorImpl;
    
    private static final int                     CORE_POOL_SIZE  = 4;
    private static final int                     MAX_POOL_SIZE   = 8;
    private static final int                     KEEP_ALIVE_TIME = 120;
    private static final TimeUnit                TIME_UNIT       = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE      = new LinkedBlockingQueue<>();
    
    private ThreadPoolExecutor mThreadPoolExecutor;
    
    private BackgroundExecutorImpl() {
        mThreadPoolExecutor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TIME_UNIT,
            WORK_QUEUE
        );
    }

    @Override
    public void execute(final BackgroundInteractor backgroundInteractor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                backgroundInteractor.run();
            }
        });
    }

    public static BackgroundExecutor getInstance() {
        if (sBackgroundExecutorImpl == null) {
            sBackgroundExecutorImpl = new BackgroundExecutorImpl();
        }
        
        return sBackgroundExecutorImpl;
    }
}
