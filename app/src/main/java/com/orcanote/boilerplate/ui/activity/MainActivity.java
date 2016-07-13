package com.orcanote.boilerplate.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orcanote.boilerplate.R;
import com.orcanote.boilerplate.presentation.presenter.MainPresenter;
import com.orcanote.boilerplate.presentation.presenter.impl.MainPresenterImpl;
import com.orcanote.boilerplate.presentation.view.MainView;
import com.orcanote.boilerplate.ui.util.ToastUtils;

/**
 * @author orcanote
 */
public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenterImpl(this);
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
}
