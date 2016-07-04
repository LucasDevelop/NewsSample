package com.lucas.newssample.images.component;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.images.ImagesFragment;
import com.lucas.newssample.images.module.ImagesModule;
import com.lucas.newssample.images.presenter.ImagesPresenter;
import com.lucas.newssample.utils.scope.FragmentScope;

import dagger.Component;

/**
 * 作者：lucas on 2016/7/4 15:32
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@FragmentScope
@Component(modules = ImagesModule.class,dependencies = AppComponent.class)
public interface ImagesComponent {
    ImagesPresenter getPresenter();
    void inject(ImagesFragment fragment);
}
