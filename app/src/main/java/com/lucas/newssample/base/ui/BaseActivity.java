package com.lucas.newssample.base.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/24 10:55
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements MvpView {
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter.attach(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除关联
        mPresenter.detach();
    }

    //初始化视图
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();

    @Override
    public void showLoading(String msg) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage(msg);
        dialog.show();
    }

    @Override
    public void hideLoading() {

    }

}
