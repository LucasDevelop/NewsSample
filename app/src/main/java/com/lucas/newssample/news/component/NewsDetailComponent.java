package com.lucas.newssample.news.component;

import com.lucas.newssample.news.module.NewsDetailModule;
import com.lucas.newssample.news.ui.NewsDetailActivity;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/30 10:21
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Component(modules = NewsDetailModule.class)
public interface NewsDetailComponent {
    NewsDetailActivity getNewsDetailActivity();
    void inject(NewsDetailActivity activity);
}
