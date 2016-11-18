package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;

public class WelcomingInteractorImpl2 implements WelcomingInteractor {

    private WelcomingRepository mRepository;

    public WelcomingInteractorImpl2(WelcomingRepository repository) {
        mRepository = repository;
    }

    @Override
    public void execute() {
        mRepository.getMessage();

        mRepository = null;
    }
}
