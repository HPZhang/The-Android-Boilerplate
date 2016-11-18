package com.orcanote.boilerplate.domain.executor;

import com.orcanote.boilerplate.domain.interactor.BackgroundInteractor;

public interface BackgroundExecutor {

    void execute(BackgroundInteractor backgroundInteractor);
}
