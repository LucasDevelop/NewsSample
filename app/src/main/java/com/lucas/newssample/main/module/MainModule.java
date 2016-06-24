package com.lucas.newssample.main.module;

import com.lucas.newssample.main.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/6/24 11:36
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Module
public class MainModule {
    private MainActivity mMainActivity;

    public MainModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    MainActivity provideMainActivity(){
        return mMainActivity;
    }
}
