package com.lucas.newssample.images.presenter;

import android.util.Log;

import com.lucas.newssample.able.OnLoadDataListener;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.beans.Images;
import com.lucas.newssample.images.ImagesFragment;
import com.lucas.newssample.images.model.ImagesModel;
import com.lucas.newssample.images.view.ImagesView;

import java.util.List;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/7/4 14:56
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class ImagesPresenter extends BasePresenter<ImagesView> implements OnLoadDataListener<List<Images>> {
    private ImagesFragment mFragment;

    @Inject
    ImagesModel mModel;

    @Inject
    public ImagesPresenter(ImagesFragment fragment) {
        mFragment = fragment;
    }

    public void loadData(){
        mModel.loadData(this);
    }

    @Override
    public void onSuccess(List<Images> data) {
        mFragment.refreshView(data);
    }

    @Override
    public void onError(String msg, int errorCode) {
        Log.d("ImagesPresenter", msg);
        mFragment.showFailedMsg(msg);
    }
}
