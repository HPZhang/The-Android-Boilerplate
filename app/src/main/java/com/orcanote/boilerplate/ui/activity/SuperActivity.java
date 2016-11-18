package com.orcanote.boilerplate.ui.activity;

import android.support.v7.app.AppCompatActivity;

import com.orcanote.boilerplate.presentation.view.SuperView;
import com.orcanote.boilerplate.ui.util.ToastUtils;

/**
 * The activity should be parent of any other activities.
 *
 * Supplying interface of device to presenter, for example: toast tool, directory structure
 * and so on.
 */
public class SuperActivity extends AppCompatActivity implements SuperView {

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this, message);
    }

    @Override
    public void showError(String message) {
        ToastUtils.showMessage(this, message);
    }
}
