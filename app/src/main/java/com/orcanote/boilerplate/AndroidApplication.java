package com.orcanote.boilerplate;

import android.app.Application;
import android.util.Log;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.CustomLogger;
import com.orcanote.boilerplate.storage.data.ContextHolder;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @author orcanote
 */
public class AndroidApplication extends Application {
    private static AndroidApplication instance;
    private JobManager jobManager;

    public AndroidApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        configureJobManager();
        configureFlowManager();
        ContextHolder.inject(this);
    }

    public static JobManager getJobManager() {
        return instance.jobManager;
    }

    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(this)
            .customLogger(new CustomLogger() {
                private static final String TAG = "JOBS";

                @Override
                public boolean isDebugEnabled() {
                    return true;
                }

                @Override
                public void d(String text, Object... args) {
                    Log.d(TAG, String.format(text, args));
                }

                @Override
                public void v(String text, Object... args) {
                    Log.v(TAG, String.format(text, args));
                }

                @Override
                public void e(Throwable t, String text, Object... args) {
                    Log.e(TAG, String.format(text, args), t);
                }

                @Override
                public void e(String text, Object... args) {
                    Log.e(TAG, String.format(text, args));
                }
            })
            .minConsumerCount(1)
            .maxConsumerCount(16)
            .loadFactor(1)
            .consumerKeepAlive(120)
            .build();
        jobManager = new JobManager(configuration);
    }

    private void configureFlowManager() {
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
