package com.example.administrator.pointordersystem.callbcak;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface BeanCallback<T> {
    void onError(String msg);
    void onSuccess(T t);

}
