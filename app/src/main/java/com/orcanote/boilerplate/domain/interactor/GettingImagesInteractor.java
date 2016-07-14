package com.orcanote.boilerplate.domain.interactor;

import com.orcanote.boilerplate.domain.repository.GettingImagesRepository;

public class GettingImagesInteractor implements Interactor {
    private GettingImagesRepository repository;

    public GettingImagesInteractor(GettingImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
