package com.orcanote.boilerplate.domain.interactor;

import com.orcanote.boilerplate.domain.interactor.impl.GettingImagesInteractorImpl;
import com.orcanote.boilerplate.domain.repository.GettingImagesRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GettingImagesInteractorImplTest {

    @Mock
    private GettingImagesRepository mRepository;

    @Test
    public void shouldCallGetImagesMethod() {
        Interactor interactor = new GettingImagesInteractorImpl(mRepository);
        interactor.execute();
        Mockito.verify(mRepository).getImages();
    }
}
