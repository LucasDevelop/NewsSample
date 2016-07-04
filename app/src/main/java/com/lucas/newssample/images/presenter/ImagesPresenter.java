package com.lucas.newssample.images.presenter;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.images.ImagesFragment;
import com.lucas.newssample.images.view.ImagesView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/7/4 14:56
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class ImagesPresenter extends BasePresenter<ImagesView> {
    private ImagesFragment mFragment;

    @Inject
    public ImagesPresenter(ImagesFragment fragment) {
        mFragment = fragment;
    }


}
