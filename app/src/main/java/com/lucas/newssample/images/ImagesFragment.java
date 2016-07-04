package com.lucas.newssample.images;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.R;
import com.lucas.newssample.base.ui.BaseFragment;
import com.lucas.newssample.images.component.DaggerImagesComponent;
import com.lucas.newssample.images.module.ImagesModule;
import com.lucas.newssample.images.presenter.ImagesPresenter;
import com.lucas.newssample.images.view.ImagesView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：lucas on 2016/7/4 14:50
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class ImagesFragment extends BaseFragment<ImagesPresenter> implements ImagesView {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.list)
    RecyclerView mList;
    @InjectView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerImagesComponent.builder()
                .imagesModule(new ImagesModule(this))
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    protected View initView() {
        View rootView = View.inflate(getActivity(), R.layout.fragment_images, null);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    protected void initData() {

    }


}
