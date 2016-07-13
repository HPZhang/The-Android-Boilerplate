package com.orcanote.boilerplate.domain.interactor;

import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl;
import com.orcanote.boilerplate.domain.interactor.impl.WelcomingInteractorImpl2;
import com.orcanote.boilerplate.domain.repository.WelcomingRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GetMessageFromDomainTest {

    @Mock
    private WelcomingInteractor.Callback callback;

    @Mock
    private WelcomingRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void welcomeMessageFound() {
        String msg = "Succeeds to get message";

        WelcomingInteractor interactor = new WelcomingInteractorImpl(callback);
        interactor.execute();

        Mockito.verify(callback).onSuccess(msg);
        Mockito.verifyNoMoreInteractions(callback);
    }

    @Test
    public void noWelcomeMessage() {
        WelcomingInteractor interactor = new WelcomingInteractorImpl2(repository);
        interactor.execute();

        Mockito.verify(repository).getMessage();
        Mockito.verifyNoMoreInteractions(repository);
    }
}
