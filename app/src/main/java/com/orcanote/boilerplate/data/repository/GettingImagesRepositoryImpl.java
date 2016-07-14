package com.orcanote.boilerplate.data.repository;

import com.orcanote.boilerplate.AndroidApplication;
import com.orcanote.boilerplate.data.job.GettingImagesJob;
import com.orcanote.boilerplate.domain.repository.GettingImagesRepository;

public class GettingImagesRepositoryImpl implements GettingImagesRepository {

    @Override
    public void getImages() {
        AndroidApplication.getJobManager().addJobInBackground(new GettingImagesJob());
    }
}
