package com.lucas.newssample.news.component;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.news.module.NewsDetailModule;
import com.lucas.newssample.news.ui.NewsDetailActivity;
import com.lucas.newssample.utils.scope.FragmentScope;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/30 10:21
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@FragmentScope
@Component(modules = NewsDetailModule.class,dependencies = AppComponent.class)
public interface NewsDetailComponent {
    void inject(NewsDetailActivity activity);
}
