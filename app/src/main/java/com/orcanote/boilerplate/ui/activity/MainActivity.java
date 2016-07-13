package com.orcanote.boilerplate.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orcanote.boilerplate.R;
import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.presenter.impl.MainPresenterImpl;
import com.orcanote.boilerplate.presentation.view.MainView;
import com.orcanote.boilerplate.ui.util.ToastUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author orcanote
 */
public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl(this);
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

        mPresenter.destroy();
    }

    @Override
    public void showError(String message) {
        ToastUtils.showError(this, message);
    }

    @OnClick(R.id.presentation_domain)
    public void connectingPresentationAndDomain() {
        mPresenter.onClickPresentationAndDomain();
    }

    @OnClick(R.id.presentation_data)
    public void connectingPresentationAndData() {
        mPresenter.onClickPresentationAndData();
    }

    @OnClick(R.id.presentation_domain_data)
    public void connectingPresentationAndDomainAndData() {
        mPresenter.onClickPresentationAndDomainAndData();
    }
}
