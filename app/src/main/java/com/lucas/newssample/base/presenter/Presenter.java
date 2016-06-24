package com.lucas.newssample.base.presenter;

import com.lucas.newssample.base.view.MvpView;

/**
 * 作者：lucas on 2016/6/24 10:47
 * 邮箱：lucas_developer@163.com
 * 说明：persenter层统一接口，用于关联view层
 */
public interface Presenter<T extends MvpView> {
    //关联view层
    void attach(T v);
    //解除关联
    void detach();
}
