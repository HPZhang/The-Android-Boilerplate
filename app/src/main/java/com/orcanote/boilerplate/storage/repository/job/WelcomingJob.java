package com.orcanote.boilerplate.storage.repository.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.orcanote.boilerplate.storage.repository.event.WelcomingEvent;

import org.greenrobot.eventbus.EventBus;

public class WelcomingJob extends Job {
    public WelcomingJob() {
        super(new Params(1).delayInMs(2 * 1000));
    }

    @Override
    public void onAdded() {
        EventBus.getDefault().post(new WelcomingEvent("Starting job."));
    }

    @Override
    public void onRun() throws Throwable {
        EventBus.getDefault().post(new WelcomingEvent("Running job."));
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
