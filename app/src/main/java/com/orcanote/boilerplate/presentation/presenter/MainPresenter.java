package com.orcanote.boilerplate.presentation.presenter;

import com.orcanote.boilerplate.storage.data.model.Image;

import java.util.List;

public interface MainPresenter extends BasePresenter {

    void onPresentationAndDomainClick();

    void onPresentationAndDataClick();

    void onPresentationAndDomainAndDataClick();

    void onGettingImagesClick();

    void onAppStarted(String message);

    void onBackgroundInteractorClick();

    void onImagesGetted(List<Image> images);
}
