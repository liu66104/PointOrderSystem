package com.example.administrator.pointordersystem.interfaces;

import com.example.administrator.pointordersystem.bean.LoginBean;
import com.example.administrator.pointordersystem.callbcak.BeanCallback;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface ILoginBean {
    String doRequest(String username, String password, BeanCallback<LoginBean> callback);
}
