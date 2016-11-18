package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;

public class WelcomingInteractorImpl implements WelcomingInteractor {

    private Callback mCallback;

    public WelcomingInteractorImpl(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void execute() {
        mCallback.onSuccess("Succeeds to get message");

        mCallback = null;
    }
}
