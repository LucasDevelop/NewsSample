package com.lucas.newssample.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/27 15:09
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements MvpView {

    @Inject
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return baseInit();
    }

    private View baseInit() {
        View view = initView();
        initData();
        mPresenter.attach(this);
        return view;
    }

    protected abstract View initView();

    protected abstract void initData();

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
