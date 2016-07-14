package com.orcanote.boilerplate.presentation.presenter.impl;

import com.orcanote.boilerplate.data.event.WelcomingEvent;
import com.orcanote.boilerplate.data.model.Message;
import com.orcanote.boilerplate.data.repository.WelcomingRepositoryImpl;
import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;
import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl;
import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl2;
import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.view.MainView;
import com.orcanote.boilerplate.util.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author orcanote
 */
public class MainPresenterImpl implements MainPresenter, WelcomingInteractor.Callback {
    private MainView mView;

    public MainPresenterImpl(MainView view) {
        mView = view;
    }

    @Override
    public void resume() {
        EventBusUtils.register(this);
    }

    @Override
    public void pause() {
        EventBusUtils.unregister(this);
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mView = null;
    }

    @Override
    public void onError(String message) {
        mView.showError(message);
    }

    @Override
    public void onSuccess(String message) {
        mView.showError(message);
    }

    @Override
    public void onFailure(String error) {
        mView.showError(error);
    }

    @Override
    public void onClickPresentationAndDomain() {
        new WelcomingInteractorImpl(this).execute();
    }

    @Override
    public void onClickPresentationAndData() {
        mView.showError(new Message().getMessage());
    }

    @Override
    public void onClickPresentationAndDomainAndData() {
        new WelcomingInteractorImpl2(new WelcomingRepositoryImpl()).execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(WelcomingEvent event) {
        mView.showError(event.getMessage());
    }
}
