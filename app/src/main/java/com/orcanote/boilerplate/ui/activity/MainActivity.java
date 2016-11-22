package com.orcanote.boilerplate.ui.activity;

import android.os.Bundle;

import com.orcanote.boilerplate.R;
import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.presenter.impl.MainPresenterImpl;
import com.orcanote.boilerplate.presentation.view.MainView;
import com.orcanote.boilerplate.storage.data.model.Image;
import com.orcanote.boilerplate.storage.repository.GettingImagesRepositoryImpl;
import com.orcanote.boilerplate.storage.repository.WelcomingRepositoryImpl;
import com.orcanote.boilerplate.storage.repository.event.WelcomingEvent;
import com.orcanote.boilerplate.threading.BackgroundExecutorImpl;
import com.orcanote.boilerplate.threading.MainExecutorImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author orcanote
 */
public class MainActivity extends SuperActivity implements MainView {

    private MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl(
            this,
            new WelcomingRepositoryImpl(),
            new GettingImagesRepositoryImpl(),
            MainExecutorImpl.getInstance(),
            BackgroundExecutorImpl.getInstance()
        );

        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();

        mPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);

        mPresenter.destroy();
    }

    @OnClick(R.id.presentation_domain)
    public void connectingPresentationAndDomain() {
        mPresenter.onPresentationAndDomainClick();
    }

    @OnClick(R.id.presentation_data)
    public void connectingPresentationAndData() {
        mPresenter.onPresentationAndDataClick();
    }

    @OnClick(R.id.presentation_domain_data)
    public void connectingPresentationAndDomainAndData() {
        mPresenter.onPresentationAndDomainAndDataClick();
    }

    @OnClick(R.id.getting_images)
    public void gettingImages() {
        mPresenter.onGettingImagesClick();
    }

    @OnClick(R.id.background_interactor)
    public void onBackgroundInteractorClick() {
        mPresenter.onBackgroundInteractorClick();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(WelcomingEvent event) {
        mPresenter.onAppStarted(event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(List<Image> images) {
        mPresenter.onImagesGetted(images);
    }
}
