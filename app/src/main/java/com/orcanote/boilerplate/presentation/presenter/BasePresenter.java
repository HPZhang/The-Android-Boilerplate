package com.orcanote.boilerplate.presentation.presenter;

public interface BasePresenter {
    /**
     * 对应Android组件的onResume事件
     */
    void resume();

    /**
     * 对应Android组件的onPause事件
     */
    void pause();

    /**
     * 对应Android组件的onStop事件
     */
    void stop();

    /**
     * 对应Android组件的onDestroy事件
     */
    void destroy();

    /**
     * 用于监听发生错误的事件
     * 调用对应的视图方法显示错误的提示信息
     * @param message 需要显示的提示信息
     */
    void onError(String message);
}
