package com.lucas.newssample.news.module;

import com.lucas.newssample.news.ui.NewsDetailActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/6/30 10:19
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Module
public class NewsDetailModule {
    private NewsDetailActivity mActivity;

    public NewsDetailModule(NewsDetailActivity activity) {
        mActivity = activity;
    }

    @Provides
    NewsDetailActivity provideNewsDetailActivity(){
        return mActivity;
    }
}
