package com.orcanote.boilerplate.domain.interactor;

import com.orcanote.boilerplate.domain.executor.BackgroundExecutor;
import com.orcanote.boilerplate.domain.executor.MainExecutor;
import com.orcanote.boilerplate.domain.interactor.impl.BackgroundInteractorImpl;
import com.orcanote.boilerplate.threading.TestMainExecutorImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BackgroundInteractorImplTest {
    
    private MainExecutor                      mMainExecutor;
    @Mock
    private BackgroundExecutor                mBackgroundExecutor;
    @Mock
    private BackgroundInteractorImpl.Callback mCallback;
    
    @Before
    public void setUp() throws Exception {
        mMainExecutor = new TestMainExecutorImpl();
    }

    @Test
    public void shouldCallCallbackMethod() {
        BackgroundInteractor interactor = new BackgroundInteractorImpl(
            mMainExecutor, mBackgroundExecutor, mCallback
        );
        interactor.run();
        Mockito.verify(mCallback).onBackgroundInteractorCompleted("This is a background interactor!");
    }
}
