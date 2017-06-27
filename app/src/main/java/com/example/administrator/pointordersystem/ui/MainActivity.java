//package com.example.administrator.pointordersystem.ui;
//
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.content.LocalBroadcastManager;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//
//import com.example.administrator.pointordersystem.R;
//
//import org.xutils.view.annotation.ContentView;
//import org.xutils.x;
//
//@ContentView(R.layout.activity_main)
//public class MainActivity extends AppCompatActivity {
//
//    private int delayTime = 4;// 广告4秒倒计时
//    private ImageView adImg;
//    private RelativeLayout rl;
//    private TextView dTime;
//    private Button skipBtn;
//    // 是否首次登陆
//    private boolean adIsFinish = false;
//    private LinearLayout ll1, ll2;
//    private Window window;
//    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000; //需要自己定义标志
//
//    @SuppressLint("JavascriptInterface")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        x.view().inject(this);
//        rl = (RelativeLayout) findViewById(R.id.rl_show_ad);
//        ll1 = (LinearLayout) findViewById(R.id.list_container);
//        ll2 = (LinearLayout) findViewById(R.id.detail_container);
//        skipBtn = (Button) findViewById(R.id.ll_ad_skip_btn);
//        adImg = (ImageView) findViewById(R.id.iv_ad_img);
//        dTime = (TextView) findViewById(R.id.tv_time);
//        adImg.setImageResource(R.mipmap.adver);
//        adIsFinish = true;
//        handler.sendEmptyMessageDelayed(1, 1000);
//        skipBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handler.removeCallbacksAndMessages(null);
//                handler = null;
//                rl.setVisibility(View.GONE);
//                ll1.setVisibility(View.VISIBLE);
//                ll2.setVisibility(View.VISIBLE);
//                sendBroadcast();
//            }
//        });
//
//
////        //建立一个左侧列表的Fragment
////        Fragment listFragment = new FragmentLeft();
////        Fragment listFragment1 = new FragmentRight();
////        //得到一个管理器，用来管理Fragment
////        FragmentManager fragmentManager = getSupportFragmentManager();
////        //用FragmentManager打开一个Fragment事务
////        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////        //把刚建立的列表放到列表容器里
////        fragmentTransaction.add(R.id.list_container, listFragment);
////        fragmentTransaction.add(R.id.detail_container, listFragment1);
////        //记得提交
////        fragmentTransaction.commit();
//
//    }
//
//    private Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    if (adIsFinish) {
//                        if (delayTime > 0) {
//                            rl.setVisibility(View.VISIBLE);
//                            dTime.setText(delayTime + "");
//                            handler.sendEmptyMessageDelayed(1, 1000);
//                            delayTime--;
//                        } else {
//                            rl.setVisibility(View.GONE);
//                            ll1.setVisibility(View.VISIBLE);
//                            ll2.setVisibility(View.VISIBLE);
//                            sendBroadcast();
//                            handler.removeCallbacksAndMessages(null);
//                            handler = null;
//                        }
//                    } else {
//                        sendBroadcast();
//                        ll1.setVisibility(View.VISIBLE);
//                        ll2.setVisibility(View.VISIBLE);
//                        rl.setVisibility(View.GONE);
//                    }
//                    break;
//
//            }
//        }
//    };
//
//    public void sendBroadcast() {
//        Intent intent1 = new Intent("MainActivity.broadcast.dialog");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
//
//    }
//
//}
