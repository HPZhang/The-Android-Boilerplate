package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.Interactor;
import com.orcanote.boilerplate.domain.repository.GettingImagesRepository;

public class GettingImagesInteractorImpl implements Interactor {

    private GettingImagesRepository mRepository;

    public GettingImagesInteractorImpl(GettingImagesRepository repository) {
        mRepository = repository;
    }

    @Override
    public void execute() {
        mRepository.getImages();

        mRepository = null;
    }
}
