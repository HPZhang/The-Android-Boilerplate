package com.orcanote.boilerplate.storage.repository.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.orcanote.boilerplate.storage.data.resolver.impl.ImagesResolver;

import org.greenrobot.eventbus.EventBus;

public class GettingImagesJob extends Job {

    public GettingImagesJob() {
        super(new Params(1));
    }

    @Override
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        EventBus.getDefault().post(new ImagesResolver(getApplicationContext()).query());
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
