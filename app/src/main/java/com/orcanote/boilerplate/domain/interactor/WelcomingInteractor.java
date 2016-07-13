package com.orcanote.boilerplate.domain.interactor;

public interface WelcomingInteractor extends Interactor {

    interface Callback {
        void onSuccess(String message);

        void onFailure(String error);
    }
}
