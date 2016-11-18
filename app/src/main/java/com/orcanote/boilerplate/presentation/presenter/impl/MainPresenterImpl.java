package com.orcanote.boilerplate.presentation.presenter.impl;

import com.orcanote.boilerplate.data.model.Image;
import com.orcanote.boilerplate.domain.executor.BackgroundExecutor;
import com.orcanote.boilerplate.domain.executor.MainExecutor;
import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;
import com.orcanote.boilerplate.domain.interactor.impl.BackgroundInteractorImpl;
import com.orcanote.boilerplate.domain.interactor.impl.GettingImagesInteractorImpl;
import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl;
import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl2;
import com.orcanote.boilerplate.domain.repository.GettingImagesRepository;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;
import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.view.MainView;

import java.util.List;

/**
 * @author orcanote
 */
public class MainPresenterImpl implements MainPresenter,
                                          WelcomingInteractor.Callback,
                                          BackgroundInteractorImpl.Callback {

    private MainView                mView;
    private WelcomingRepository     mWelcomingRepository;
    private GettingImagesRepository mGettingImagesRepository;
    private MainExecutor            mMainExecutor;
    private BackgroundExecutor      mBackgroundExecutor;

    public MainPresenterImpl(MainView view,
                             WelcomingRepository welcomingRepository,
                             GettingImagesRepository gettingImagesRepository,
                             MainExecutor mainExecutor,
                             BackgroundExecutor backgroundExecutor) {
        mView = view;
        mWelcomingRepository = welcomingRepository;
        mGettingImagesRepository = gettingImagesRepository;
        mMainExecutor = mainExecutor;
        mBackgroundExecutor = backgroundExecutor;
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
        mWelcomingRepository = null;
        mGettingImagesRepository = null;
    }

    @Override
    public void onError(String message) {
        mView.showError(message);
    }

    @Override
    public void onSuccess(String message) {
        mView.showMessage(message);
    }

    @Override
    public void onFailure(String error) {
        mView.showError(error);
    }

    @Override
    public void onPresentationAndDomainClick() {
        new WelcomingInteractorImpl(this).execute();
    }

    @Override
    public void onPresentationAndDataClick() {
        mView.showMessage("Welcome to Android Boilerplate.");
    }

    @Override
    public void onPresentationAndDomainAndDataClick() {
        new WelcomingInteractorImpl2(mWelcomingRepository).execute();
    }

    @Override
    public void onGettingImagesClick() {
        new GettingImagesInteractorImpl(mGettingImagesRepository).execute();
    }

    @Override
    public void onAppStarted(String message) {
        mView.showMessage(message);
    }

    @Override
    public void onBackgroundInteractorClick() {
        new BackgroundInteractorImpl(mMainExecutor, mBackgroundExecutor, this).execute();
    }

    @Override
    public void onImagesGetted(List<Image> images) {
        mView.showMessage("The number of images is " + images.size() + ".");
    }

    @Override
    public void onBackgroundInteractorCompleted(String message) {
        mView.showMessage(message);
    }
}
