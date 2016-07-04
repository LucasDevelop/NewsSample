package com.lucas.newssample.main.component;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.utils.scope.ActivityScope;
import com.lucas.newssample.main.module.MainModule;
import com.lucas.newssample.main.ui.MainActivity;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/24 11:39
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent {
        void inject(MainActivity mainActivity);
}
