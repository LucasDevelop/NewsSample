package com.lucas.newssample.base.presenter;

import com.lucas.newssample.base.view.MvpView;


/**
 * 作者：lucas on 2016/6/24 10:50
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private T mV;

    @Override
    public void attach(T v) {
        mV = v;
    }

    @Override
    public void detach() {
        mV = null;
    }

    //判断view层是否关联上
    public boolean isViewAttached() {
        return mV != null;
    }
}
