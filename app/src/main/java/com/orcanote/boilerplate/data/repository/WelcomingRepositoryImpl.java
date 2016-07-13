package com.orcanote.boilerplate.data.repository;

import com.orcanote.boilerplate.AndroidApplication;
import com.orcanote.boilerplate.data.job.WelcomingJob;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;

public class WelcomingRepositoryImpl implements WelcomingRepository {

    @Override
    public void getMessage() {
        AndroidApplication.getJobManager().addJobInBackground(new WelcomingJob());
    }
}
