package com.lucas.newssample.images.module;

import com.lucas.newssample.images.ImagesFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/7/4 15:30
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Module
public class ImagesModule {
    private ImagesFragment mFragment;

    public ImagesModule(ImagesFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    ImagesFragment provideImagesFragment(){
        return mFragment;
    }
}
