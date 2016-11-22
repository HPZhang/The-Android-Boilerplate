package com.orcanote.boilerplate.storage.repository;

import com.orcanote.boilerplate.AndroidApplication;
import com.orcanote.boilerplate.storage.repository.job.WelcomingJob;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;

public class WelcomingRepositoryImpl implements WelcomingRepository {

    @Override
    public void getMessage() {
        AndroidApplication.getJobManager().addJobInBackground(new WelcomingJob());
    }
}
