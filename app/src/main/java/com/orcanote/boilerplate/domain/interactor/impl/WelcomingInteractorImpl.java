package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;

public class WelcomingInteractorImpl implements WelcomingInteractor {
    private Callback callback;

    public WelcomingInteractorImpl(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void execute() {
        if (Math.round(Math.random()) % 2 == 0) {
            callback.onSuccess("Succeeds to get message");
        } else {
            callback.onSuccess("Fails to get message");
        }
    }
}
