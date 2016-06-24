package com.lucas.newssample.base.view;

/**
 * 作者：lucas on 2016/6/24 10:43
 * 邮箱：lucas_developer@163.com
 * 说明：view层统一接口
 */
public interface MvpView {
    void showLoading(String msg);
    void hideLoading();
}
