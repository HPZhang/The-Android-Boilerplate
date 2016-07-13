package com.orcanote.boilerplate.presentation.presenter.impl;

import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.view.MainView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author orcanote
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mView;

    public MainPresenterImpl(MainView view) {
        mView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mView = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onError(String message) {
        mView.showError(message);
    }
}
