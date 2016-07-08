package com.lucas.newssample.images.view;

import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.Images;

import java.util.List;

/**
 * 作者：lucas on 2016/7/4 14:51
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public interface ImagesView extends MvpView{
    void refreshView(List<Images> data);
    void showFailedMsg(String msg);
}
