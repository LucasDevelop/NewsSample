package com.lucas.newssample.news.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;

import com.lucas.newssample.App;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.ui.NewsListFragment;
import com.lucas.newssample.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：lucas on 2016/6/27 14:58
 * 邮箱：lucas_developer@163.com
 * 说明：新闻列表p层
 */
public class NewsListPresenter extends BasePresenter<MvpView> {
    private NewsListFragment mFragment;

    @Inject
    public NewsListPresenter(NewsListFragment fragment) {
        mFragment = fragment;
    }

    public void loadData(int newsType, int limit) {
        Log.d("NewsListPresenter", "loadData111");
        String endUrl = getUrl(newsType, limit);
        rx.Observable
                .just(endUrl)
                .map(s -> App.getApp().getAppComponent().getApiService().getNewsList(s).T1348647909107)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> {
                    List<News.T1348647909107Bean> been = new ArrayList<>();
                    Log.d("NewsListPresenter", "news11:" + news);
                    if (news == null) {
                        return;
                    }
                    for (int i = 0; i < news.size(); i++) {
                        News.T1348647909107Bean b = news.get(i);
                        if (!TextUtils.isEmpty(b.digest))
                            been.add(b);
                        mFragment.refreshData(been);
                        mFragment.hideLoading();
                    }
                });
    }
//    rx.Observable
//            .just(endUrl)
//            .flatMap(s -> rx.Observable
//            .from(App.getApp().getAppComponent().getApiService().getNewsList(s).T1348647909107))
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(t -> {
//        List<News.T1348647909107Bean> been = new ArrayList<>();
//        if (t != null && !TextUtils.isEmpty(t.digest))
//            been.add(t);
//        mFragment.refreshData(been);
//        mFragment.hideLoading();
//    });

    private String getUrl(int newsType, int limit) {
        StringBuilder builder = new StringBuilder();
        switch (newsType) {
            case NewsListFragment.NEWS_TYPE_TOP:
                builder.append(Constant.TOP_URL).append(Constant.TOP_ID);
                break;
            case NewsListFragment.NEWS_TYPE_CARS:
                builder.append(Constant.COMMON_URL).append(Constant.CAR_ID);
                break;
            case NewsListFragment.NEWS_TYPE_NBA:
                builder.append(Constant.COMMON_URL).append(Constant.NBA_ID);
                break;
            case NewsListFragment.NEWS_TYPE_JOKES:
                builder.append(Constant.COMMON_URL).append(Constant.JOKE_ID);
                break;
        }
        builder.append("/").append(limit).append(Constant.END_URL);
        return builder.toString();
    }
}
