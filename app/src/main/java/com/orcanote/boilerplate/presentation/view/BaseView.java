package com.orcanote.boilerplate.presentation.view;

/**
 * <p>
 * 所有视图组件必须实现的接口
 * </p>
 */
public interface BaseView {

    /**
     * 在交互过程中，如果出现错误，使用这个工具显示错误的提示信息
     * @param message 需要显示的提示信息
     */
    void showError(String message);
}
