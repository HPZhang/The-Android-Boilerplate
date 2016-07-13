package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;

public class WelcomingInteractorImpl implements WelcomingInteractor {
    private Callback callback;

    public WelcomingInteractorImpl(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void execute() {
        callback.onSuccess("Succeeds to get message");
    }
}
