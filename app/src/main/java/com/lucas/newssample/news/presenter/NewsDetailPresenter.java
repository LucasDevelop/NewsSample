package com.lucas.newssample.news.presenter;

import android.util.Log;

import com.lucas.newssample.able.OnLoadDataListener;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.NewsDetail;
import com.lucas.newssample.main.ui.MainActivity;
import com.lucas.newssample.news.model.NewsModel;
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
    NewsModel mModel;

    @Inject
    public NewsDetailPresenter(NewsDetailActivity activity) {
        mActivity = activity;
    }

    public void loadNewsDetail(String id){
        mActivity.isShowProgress(true);
        mModel.getNewsDetail(id, new OnLoadDataListener<NewsDetail>() {
            @Override
            public void onSuccess(NewsDetail data) {
                mActivity.isShowProgress(false);
                mActivity.loadContent(data.body);
            }

            @Override
            public void onError(String msg, int errorCode) {
                Log.d("NewsDetailPresenter", msg);
            }
        });
    }
}
