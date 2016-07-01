package com.lucas.newssample.able;

/**
 * 作者：lucas on 2016/7/1 10:38
 * 邮箱：lucas_developer@163.com
 * 说明：数据加载回调
 */
public interface OnLoadDataListener<T> {
    void onSuccess(T data);
    void onError(String msg,int errorCode);
}
