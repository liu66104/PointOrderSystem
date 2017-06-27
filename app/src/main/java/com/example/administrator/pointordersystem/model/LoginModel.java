package com.example.administrator.pointordersystem.model;


import android.util.Log;

import com.example.administrator.pointordersystem.base.MD5Util;
import com.example.administrator.pointordersystem.bean.LoginBean;
import com.example.administrator.pointordersystem.callbcak.BeanCallback;
import com.example.administrator.pointordersystem.interfaces.ILoginBean;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.administrator.pointordersystem.base.Url.myUrl;

/**
 * Created by Administrator on 2017/6/15.
 */

public class LoginModel implements ILoginBean {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    public String doRequest(final String username, final String password, final BeanCallback<LoginBean> callback) {

        Log.d("zoule", "doRequest: ");
        final OkHttpClient client = new OkHttpClient();


            new Thread(new Runnable() {
                @Override
                public void run() {

                    JSONObject object = new JSONObject();

                    try {
                        object.put("account", username);
                        object.put("mpassword", MD5Util.MD5Encode(password, "utf-8"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                    RequestBody body = RequestBody.create(JSON, String.valueOf(object));
                    Request request = new Request.Builder()
                            .url(myUrl)
                            .post(body)
                            .build();
                    Response response = null;
                    try {
                        response = client.newCall(request).execute();
                        if (response.isSuccessful()) {


                            Gson gson = new Gson();
                            LoginBean bean = null;

                                bean = gson.fromJson(response.body().string(), LoginBean.class);
                                callback.onSuccess(bean);


                        } else {

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }





                }
            }).start();//这个start()方法不要忘记了

        return null;
    }
}
//        try {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    JSONObject object = new JSONObject();
//                    try {
//                        object.put("account", username);
//                        object.put("mpassword", MD5Util.MD5Encode(password, "utf-8"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    String sr = Post.sendPost(myUrl+"/appload/login.action", object);
//
//
//                    if (sr != null || !sr.equals("")) {
//
//                        Gson gson = new Gson();
//                        LoginBean bean = gson.fromJson(sr, LoginBean.class);
//                        callback.onSuccess(bean);
//
//                    } else {
//
//                    }
//                }
//            }).start();//这个start()方法不要忘记了
//        }catch (Exception e){
//            e.printStackTrace();
//            callback.onError(e.getMessage());
//        }
