package com.lucas.newssample.news.presenter;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.news.ui.NewsDetailActivity;
import com.lucas.newssample.news.view.NewsDetailView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/30 10:23
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class NewsDetailPresenter extends BasePresenter<MvpView> {
    private NewsDetailActivity mActivity;

    @Inject
    public NewsDetailPresenter(NewsDetailActivity activity) {
        mActivity = activity;
    }

    public void loadNewsDetail(String id){

    }
}
