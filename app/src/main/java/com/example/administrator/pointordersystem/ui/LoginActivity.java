package com.example.administrator.pointordersystem.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.administrator.pointordersystem.R;
import com.example.administrator.pointordersystem.base.LoadingDialog;
import com.example.administrator.pointordersystem.base.MD5Util;
import com.example.administrator.pointordersystem.base.Post;
import com.example.administrator.pointordersystem.bean.LoginBean;
import com.example.administrator.pointordersystem.callbcak.BeanCallback;
import com.example.administrator.pointordersystem.model.LoginModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.io.OutputStream;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.attr.value;
import static com.example.administrator.pointordersystem.base.Url.myUrl;


/**
 * Created by Administrator on 2017/3/2.
 */


@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    private OutputStream outputStream;
    @ViewInject(R.id.btn_login)
    private Button btn;
//    @ViewInject(R.id.btn_set)
//    private Button btn_set;
    @ViewInject(R.id.et_username)
    private EditText et_username;
    @ViewInject(R.id.et_password)
    private EditText et_password;


    private String username;
    private String password;
    private LoadingDialog dialog;
    private String m_szWLANMAC;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        //设备的唯一标识
        @SuppressLint("WifiManagerLeak") WifiManager wm = (WifiManager) getSystemService(this.WIFI_SERVICE);
        m_szWLANMAC = wm.getConnectionInfo().getMacAddress();

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("zoule", "onClick: 1");
                username = et_username.getText().toString();
                password = et_password.getText().toString();




                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("zoule", "onClick: 2");
                        //创建OkHttpClient对象
                        OkHttpClient client = new OkHttpClient();

                        FormBody body = new FormBody.Builder().add("account",username).add("mpassword", MD5Util.MD5Encode(password, "utf-8")).build();


                        Request request = new Request.Builder()
                                .url(myUrl+"/appload/login.action")
                                .post(body)
                                .build();
                        Log.d("zoule", "onClick: 3");
                        try {
                            Response response = client.newCall(request).execute();
                            if (response.isSuccessful()) {

                                Log.d("zoule", "onClick: 4");
                                Gson gson = new Gson();
                                LoginBean loginBean = null;

                                loginBean = gson.fromJson(response.body().string(), LoginBean.class);

                                if (loginBean.getCode() == 1) {
                                    dialog.close();
                                    Toast.makeText(LoginActivity.this, "chenggong", Toast.LENGTH_SHORT).show();
//                                SharedPreferences sp = getSharedPreferences("Cid", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sp.edit();
//                                editor.putString("id", loginBean.getMsg());
//                                editor.commit();
//                                Intent intent = new Intent(LoginActivity.this, ChoosePrinterActivity.class);
//                                startActivity(intent);
//                                finish();
                                } else if (loginBean.getCode() == 0) {
                                    dialog.close();
                                    Toast toast = Toast.makeText(LoginActivity.this, "账号或密码错误",
                                            Toast.LENGTH_LONG);
                                    //可以控制toast显示的位置
                                    toast.setGravity(Gravity.CENTER, 0, 10);
                                    toast.show();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.d("zoule", String.valueOf(e));
                        }


                    }
                }).start();//这个start()方法不要忘记了


//                if (!username.trim().equals("") || !password.trim().equals("")) {
//
//                    dialog = new LoadingDialog(LoginActivity.this, "登录中...");
//                    dialog.show();
//                    LoginModel loginModel = new LoginModel();
//                    loginModel.doRequest(username, password, new BeanCallback<LoginBean>() {
//                        @Override
//                        public void onError(String msg) {
//                            dialog.close();
//                            Toast toast = Toast.makeText(LoginActivity.this, "网络错误",
//                                    Toast.LENGTH_LONG);
//                            //可以控制toast显示的位置
//                            toast.setGravity(Gravity.CENTER, 0, 10);
//                            toast.show();
//                        }
//
//                        @Override
//                        public void onSuccess(LoginBean loginBean) {
//                            if (loginBean.getCode() == 1) {
//                                dialog.close();
//                                Toast.makeText(LoginActivity.this, "chenggong", Toast.LENGTH_SHORT).show();
////                                SharedPreferences sp = getSharedPreferences("Cid", MODE_PRIVATE);
////                                SharedPreferences.Editor editor = sp.edit();
////                                editor.putString("id", loginBean.getMsg());
////                                editor.commit();
////                                Intent intent = new Intent(LoginActivity.this, ChoosePrinterActivity.class);
////                                startActivity(intent);
////                                finish();
//                            } else if (loginBean.getCode() == 0) {
//                                dialog.close();
//                                Toast toast = Toast.makeText(LoginActivity.this, "账号或密码错误",
//                                        Toast.LENGTH_LONG);
//                                //可以控制toast显示的位置
//                                toast.setGravity(Gravity.CENTER, 0, 10);
//                                toast.show();
//                            }
//
//
//                        }
//                    });
//
//
//                } else {
//
//                    Toast toast = Toast.makeText(LoginActivity.this, "账户或密码不能为空",
//                            Toast.LENGTH_LONG);
//                    //可以控制toast显示的位置
//                    toast.setGravity(Gravity.CENTER, 0, 10);
//                    toast.show();
//                }


           }
        });


    }





}


