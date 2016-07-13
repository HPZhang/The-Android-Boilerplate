package com.orcanote.boilerplate.domain.interactor.impl;

import com.orcanote.boilerplate.domain.interactor.WelcomingInteractor;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;

public class WelcomingInteractorImpl2 implements WelcomingInteractor {
    private WelcomingRepository repository;

    public WelcomingInteractorImpl2(WelcomingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.post();
    }
}
