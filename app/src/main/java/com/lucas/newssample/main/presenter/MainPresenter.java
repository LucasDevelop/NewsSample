package com.lucas.newssample.main.presenter;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.main.ui.MainActivity;
import com.lucas.newssample.main.view.MainView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/24 11:12
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class MainPresenter extends BasePresenter<MainView> {
    private MainActivity mMainActivity;
    @Inject
    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    public void loadData(){
        mMainActivity.showLoading("Loading...");
    }
}
