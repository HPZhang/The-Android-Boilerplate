package com.orcanote.boilerplate.data.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.orcanote.boilerplate.data.event.WelcomingEvent;
import com.orcanote.boilerplate.util.EventBusUtils;

public class WelcomingJob extends Job {
    public WelcomingJob() {
        super(new Params(1).delayInMs(2 * 1000));
    }

    @Override
    public void onAdded() {
        EventBusUtils.post(new WelcomingEvent("Starting job."));
    }

    @Override
    public void onRun() throws Throwable {
        EventBusUtils.post(new WelcomingEvent("Running job."));
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
