package com.orcanote.boilerplate.presentation.presenter;

public interface BasePresenter {
    /**
     * Call in onResume
     */
    void resume();

    /**
     * Call in onPause
     */
    void pause();

    /**
     * Call in onStop
     */
    void stop();

    /**
     * Call in onDestroy
     */
    void destroy();

    /**
     * Show the message of interaction
     * @param message message to be showed
     */
    void onError(String message);
}
