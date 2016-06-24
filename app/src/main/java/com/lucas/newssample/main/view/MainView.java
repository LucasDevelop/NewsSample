package com.lucas.newssample.main.view;

import com.lucas.newssample.base.view.MvpView;

/**
 * 作者：lucas on 2016/6/24 11:13
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public interface MainView extends MvpView {
    void switch2News();
    void switch2Images();
    void switch2Weather();
    void switch2About();
}
