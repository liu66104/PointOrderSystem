//package com.example.administrator.pointordersystem.ui;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.administrator.pointordersystem.R;
//import com.example.administrator.pointordersystem.bean.MenuBean;
//import com.example.administrator.pointordersystem.bean.PrinterBean;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.xutils.http.annotation.HttpResponse;
//import org.xutils.view.annotation.ContentView;
//import org.xutils.view.annotation.ViewInject;
//import org.xutils.x;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Type;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static com.example.administrator.pointordersystem.base.Url.myUrl;
//
//
///**
// * Created by Administrator on 2017/4/17.
// */
//@ContentView(R.layout.activity_add)
//public class AddPrinterActivity extends AppCompatActivity {
//
//
//    @ViewInject(R.id.btn_go_main)
//    private Button btn_go_main;
//    @ViewInject(R.id.btn_back)
//    private Button btn_back;
//    private OutputStream outputStream;
//    private int printer_num;
//    @ViewInject(R.id.ll_add)
//    private LinearLayout ll;
//    private String cid;
//    private SharedPreferences sp;
//    private ArrayList<Integer> MultiChoiceID = new ArrayList<Integer>();
//    @ViewInject(R.id.tv_main_set_printer)
//    private TextView tv_main_set;
//    @ViewInject(R.id.et_main_ip)
//    private EditText et_main_ip;
//    @ViewInject(R.id.btn_main_test)
//    private Button btn_main_test;
//    @ViewInject(R.id.btn_main_save)
//    private Button btn_main_save;
//    private List<MenuBean> menuData;
//    private List<String> type_data;
//
//    private static final byte[][] byteCommands = {
//            { 0x1b, 0x40 },// 0复位打印机
//            { 0x1b, 0x4d, 0x00 },// 1标准ASCII字体
//            { 0x1b, 0x4d, 0x01 },// 2压缩ASCII字体
//            { 0x1d, 0x21, 0x00 },// 3字体不放大
//            { 0x1d, 0x21, 0x02 },// 4宽高加倍
//            { 0x1d, 0x21, 0x11 },// 5宽高加倍
//            { 0x1d, 0x21, 0x11 },// 6宽高加倍
//            { 0x1b, 0x45, 0x00 },// 7取消加粗模式
//            { 0x1b, 0x45, 0x01 },// 8选择加粗模式
//            { 0x1b, 0x7b, 0x00 },// 9取消倒置打印
//            { 0x1b, 0x7b, 0x01 },// 10选择倒置打印
//            { 0x1d, 0x42, 0x00 },// 11取消黑白反显
//            { 0x1d, 0x42, 0x01 },// 12选择黑白反显
//            { 0x1b, 0x56, 0x00 },// 13取消顺时针旋转90°
//            { 0x1b, 0x56, 0x01 },// 14选择顺时针旋转90
//            { 0x1b, 0x61, 0x30 },// 15左对齐
//            { 0x1b, 0x61, 0x31 },// 16居中对齐
//            { 0x1b, 0x61, 0x32 },// 17右对齐
//            { 0x1b, 0x40,0x1d, 0x56,0x00 },// 18切纸
//            { 0x0a }, //换行
//            { 0x1d, 0x21, 0x11}
//    };
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        x.view().inject(this);
//
//        SharedPreferences sp1 = getSharedPreferences("Cid", MODE_PRIVATE);
//        cid = sp1.getString("id", null);
//
//        sp = getSharedPreferences("wifi_printer", MODE_PRIVATE);
//        printer_num = sp.getInt("printerNum", 0);
//
//        sendRequestWithHttpClient();
//
//
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(AddPrinterActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//
//        String ip = sp.getString("MainIp", null);
//        if (ip == null || ip.trim().equals("")) {
//            tv_main_set.setText("还为设置前台打印机");
//        } else {
//            tv_main_set.setText("前台打印机的地址为：" + ip);
//        }
//
//        btn_main_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (et_main_ip.getText().toString().trim().equals("") || et_main_ip.getText() == null) {
//                    Message msg = new Message();
//                    msg.what = 0;
//                    msg.arg1 = (int) (0);
//                    handler.sendMessage(msg);
//                } else {
//                    String ip = et_main_ip.getText().toString();
//                    SharedPreferences sp = getSharedPreferences("wifi_printer", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString("MainIp", ip);
//                    editor.commit();
//                    Message msg = new Message();
//                    msg.what = 2;
//                    msg.arg1 = (int) (0);
//                    handler.sendMessage(msg);
//                }
//            }
//        });
//
//        btn_main_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (et_main_ip.getText().toString().trim().equals("") || et_main_ip.getText() == null) {
//                    Message msg = new Message();
//                    msg.what = 0;
//                    msg.arg1 = (int) (0);
//                    handler.sendMessage(msg);
//                } else {
//                    final String ip = et_main_ip.getText().toString();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//
//                                SocketAddress ipe = new InetSocketAddress(ip, 9100);
//                                Socket socket = new Socket();
//                                socket.connect(ipe);
//                                Log.d("12313asxzxc", ip + "2");
//                                if (socket.isConnected()) {
//                                    outputStream = socket.getOutputStream();
//                                    // 执行其他命令之前 先进行复位
//                                    outputStream.write(byteCommands[0]);
//                                    // 宽高加倍指
//                                    // 恢复到标准字体
//                                    outputStream.write(byteCommands[1]);
//                                    //居中对齐
//                                    outputStream.write(byteCommands[16]);
//                                    sendMessage1("欢迎光临");
//                                    sendMessage1(" \n");
//                                    sendMessage1(" \n");
//                                    outputStream.write(byteCommands[19]);
//                                    sendMessage1("拓远餐饮");
//                                    sendMessage1(" \n");
//                                    sendMessage1(" \n");
//                                    sendMessage1("========================================");
//                                    sendMessage1("请妥善保管好");
//                                    outputStream.write(byteCommands[15]);
//                                    sendMessage1(" \n");
//                                    sendMessage1("谢谢光临");
//                                    sendMessage1(" \n");
//                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
//                                    Date curDate = new Date(System.currentTimeMillis());
//                                    String str = formatter.format(curDate);
//                                    sendMessage1(str);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[19]);
//                                    outputStream.write(byteCommands[18]);
//                                    outputStream.flush();
//                                    socket.close();
//                                    Log.d("12313asxzxc", ip);
//                                } else {
//                                    Log.d("12313asxzxc", ip + "1");
//                                    Message msg = new Message();
//                                    msg.what = 1;
//                                    msg.arg1 = (int) (0);
//                                    handler.sendMessage(msg);
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
//                }
//            }
//        });
//
//        btn_go_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent  = new Intent(AddPrinterActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }
//
//
//    @Override
//    protected void onDestroy() {
//
//        super.onDestroy();
//    }
//
//    private Handler handler =  new Handler() {
//
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    int c = msg.arg1 + 1;
//                    Toast toast = Toast.makeText(AddPrinterActivity.this, "第" + c + "台输入的ip地址不能为空", Toast.LENGTH_SHORT);
//                    //可以控制toast显示的位置
//                    toast.setGravity(Gravity.CENTER, 0, 10);
//                    toast.show();
//                    break;
//                case 1:
//                    int a = msg.arg1 + 1;
//                    Toast toast1 = Toast.makeText(AddPrinterActivity.this, "第" + a + "台打印机输入的ip地址不正确", Toast.LENGTH_SHORT);
//                    //可以控制toast显示的位置
//                    toast1.setGravity(Gravity.CENTER, 0, 10);
//                    toast1.show();
//                    break;
//                case 2:
//                    int b = msg.arg1 + 1;
//                    Toast toast2 = Toast.makeText(AddPrinterActivity.this, "第" + b + "台打印机保存成功", Toast.LENGTH_SHORT);
//                    //可以控制toast显示的位置
//                    toast2.setGravity(Gravity.CENTER, 0, 10);
//                    toast2.show();
//                    break;
//                case 3:
//                    int d = msg.arg1 + 1;
//                    Toast toast3 = Toast.makeText(AddPrinterActivity.this, "第" + d + "台打印机建立连接失败", Toast.LENGTH_SHORT);
//                    //可以控制toast显示的位置
//                    toast3.setGravity(Gravity.CENTER, 0, 10);
//                    toast3.show();
//                    break;
//                case 4:
//
//                    String response = (String) msg.obj;
//                    Gson gson = new Gson();
//                    Type type = new TypeToken<List<MenuBean>>() {
//                    }.getType();
//
//                    menuData = gson.fromJson(response, type);
//                    final int s = menuData.size();
//
//
//                    final String[] array=new String[s];
//                    for(int i=0;i<s;i++){
//                        array[i]=menuData.get(i).getMuname();
//                    }
//
//
//
//
//
//                    int size = printer_num;
//                    for (int i = 0; i < size; i++) {
//                        View view = LayoutInflater.from(AddPrinterActivity.this).inflate(R.layout.add_item, null);
//                        final EditText et = (EditText) view.findViewById(R.id.et_ip);
//                        Button btn = (Button) view.findViewById(R.id.btn_test);
//                        Button btn_save = (Button) view.findViewById(R.id.btn_save);
//                        TextView tv = (TextView) view.findViewById(R.id.tv_set_printer);
//                        Button btn_type = (Button) view.findViewById(R.id.btn_set_type);
//                        btn_type.setOnClickListener(new View.OnClickListener() {
//
//                            @Override
//                            public void onClick(View v) {
//                                final boolean [] pd = new boolean[s];
//                                for (int i = 0; i < s; i++) {
//                                    pd[i] = false;
//                                }
//                                AlertDialog.Builder builder = new AlertDialog.Builder(AddPrinterActivity.this);
//                                MultiChoiceID.clear();
//                                builder.setTitle("多项选择");
//                                //  设置多选项
//                                builder.setMultiChoiceItems(array,pd,
//                                        new DialogInterface.OnMultiChoiceClickListener() {
//
//                                            @Override
//                                            public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
//                                                // TODO Auto-generated method stub
//                                                if (arg2) {
//                                                    MultiChoiceID.add(arg1);
//                                                    String tip = "你选择了"+array[arg1];
//                                                    Toast toast = Toast.makeText(getApplicationContext(), tip, Toast.LENGTH_SHORT);
//                                                    toast.show();
//                                                }
//                                                else {
//                                                    MultiChoiceID.remove(arg1);
//                                                }
//                                            }
//                                        });
//                                //  设置确定按钮
//                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface arg0, int arg1) {
//                                        // TODO Auto-generated method stub
//                                        String str = "";
//                                        type_data = new ArrayList<String>();
//                                        int size = MultiChoiceID.size();
//                                        for(int i = 0; i < size; i++) {
//                                            str += (array[MultiChoiceID.get(i)]+",");
//                                            type_data.add(array[MultiChoiceID.get(i)]);
//                                        }
//                                        Toast toast = Toast.makeText(getApplicationContext(), "你选择了"+str, Toast.LENGTH_LONG);
//                                        toast.show();
//                                    }
//                                });
//                                //  设置取消按钮
//                                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface arg0, int arg1) {
//                                        // TODO Auto-generated method stub
//
//                                    }
//                                });
//
//                                builder.create().show();
//                            }
//                        });
//
//
//                        String ip = sp.getString("ip" + i, null);
//                        PrinterBean bean = gson.fromJson(ip,PrinterBean.class);
//
//
//                        if (ip == null || ip.trim().equals("")) {
//                            tv.setText("还未设置打印机");
//                        } else {
//                            String typeRead = "";
//                            for (int j = 0; j <bean.getTypename().size() ; j++) {
//                                typeRead = typeRead+ bean.getTypename().get(j).getName()+",";
//                            }
//                            tv.setText("已设置的打印机IP为   " + bean.getIp()+"设置的打印种类为"+typeRead);
//                        }
//
//                        final int finalI = i;
//                        btn.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (et.getText().toString().trim().equals("") || et.getText() == null) {
//                                    Message msg = new Message();
//                                    msg.what = 0;
//                                    msg.arg1 = (int) (finalI);
//                                    handler.sendMessage(msg);
//                                } else {
//                                    new Thread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            try {
//                                                String ip = et.getText().toString();
//                                                SocketAddress ipe = new InetSocketAddress(ip, 9100);
//                                                Socket socket = new Socket();
//                                                socket.connect(ipe);
//                                                Log.d("12313asxzxc", ip + "2");
//                                                if (socket.isConnected()) {
//                                                    outputStream = socket.getOutputStream();
//                                                    // 执行其他命令之前 先进行复位
//                                                    outputStream.write(byteCommands[0]);
//                                                    // 宽高加倍指
//                                                    // 恢复到标准字体
//                                                    outputStream.write(byteCommands[1]);
//                                                    //居中对齐
//                                                    outputStream.write(byteCommands[16]);
//                                                    sendMessage1("欢迎光临");
//                                                    sendMessage1(" \n");
//                                                    sendMessage1(" \n");
//                                                    outputStream.write(byteCommands[19]);
//                                                    sendMessage1("拓远餐饮");
//                                                    sendMessage1(" \n");
//                                                    sendMessage1(" \n");
//                                                    sendMessage1("========================================");
//                                                    sendMessage1("请妥善保管好");
//                                                    outputStream.write(byteCommands[15]);
//                                                    sendMessage1(" \n");
//                                                    sendMessage1("谢谢光临");
//                                                    sendMessage1(" \n");
//                                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
//                                                    Date curDate = new Date(System.currentTimeMillis());
//                                                    String str = formatter.format(curDate);
//                                                    sendMessage1(str);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[19]);
//                                                    outputStream.write(byteCommands[18]);
//                                                    outputStream.flush();
//                                                    socket.close();
//                                                    Log.d("12313asxzxc", ip);
//                                                } else {
//                                                    Log.d("12313asxzxc", ip + "1");
//                                                    Message msg = new Message();
//                                                    msg.what = 1;
//                                                    msg.arg1 = (int) (finalI);
//                                                    handler.sendMessage(msg);
//                                                }
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    }).start();
//                                }
//                            }
//                        });
//                        btn_save.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (et.getText().toString().trim().equals("") || et.getText() == null) {
//                                    Message msg = new Message();
//                                    msg.what = 0;
//                                    msg.arg1 = (int) (finalI);
//                                    handler.sendMessage(msg);
//                                } else {
//                                    String ip = et.getText().toString();
//
//
//                                    JSONObject object = new JSONObject();
//                                    JSONArray jsonArray = new JSONArray();
//                                    JSONObject tmpObj = null;
//                                    try {
//                                        for (int i = 0; i < type_data.size(); i++) {
//                                            tmpObj = new JSONObject();
//                                            //商户主键
//                                            tmpObj.put("name", type_data.get(i));
//
//                                            jsonArray.put(tmpObj);
//                                        }
//                                        object.put("typename", jsonArray);
//                                        object.put("ip", ip);
//
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//
//                                    Log.d("haoxiangni", object.toString());
//
//                                    SharedPreferences sp = getSharedPreferences("wifi_printer", Context.MODE_PRIVATE);
//                                    SharedPreferences.Editor editor = sp.edit();
//                                    editor.putString("ip" + finalI, object.toString());
//                                    editor.commit();
//
//
//                                    Message msg = new Message();
//                                    msg.what = 2;
//                                    msg.arg1 = (int) (finalI);
//                                    handler.sendMessage(msg);
//                                }
//                            }
//                        });
//                        //监听item跳转
//                        ll.addView(view);
//                    }
//
//                    break;
//                default:
//                    Toast.makeText(AddPrinterActivity.this, "错误", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//
//    };
//
//    private void sendMessage1(String s) throws IOException {
//
//        // Check that we're actually connected before trying anything
//        // Check that there's actually something to send
//        if (s.length() > 0) {
//            // Get the message bytes and tell the BluetoothService to write
//            byte[] send;
//            try {
//                send = s.getBytes("GB2312");
//                outputStream.write(send);
//            } catch (UnsupportedEncodingException e) {
//                send = s.getBytes();
//            }
//        }
//
//    }
//
//
//    private void sendRequestWithHttpClient() {
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                //用HttpClient发送请求，分为五步
//                //第一步：创建HttpClient对象
//                HttpClient httpCient = new DefaultHttpClient();
//                //第二步：创建代表请求的对象,参数是访问的服务器地址
//                HttpGet httpGet = new HttpGet(myUrl + "/appmenu/menu.action?mcid=" + cid);
//                try {
//                    //第三步：执行请求，获取服务器发还的相应对象
//                    HttpResponse httpResponse = httpCient.execute(httpGet);
//                    //第四步：检查相应的状态是否正常：检查状态码的值是200表示正常
//                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                        //第五步：从相应对象当中取出数据，放到entity当中
//                        HttpEntity entity = httpResponse.getEntity();
//                        String response = EntityUtils.toString(entity, "utf-8");//将entity当中的数据转换为字符串
//                        //在子线程中将Message对象发出去
//                        Message message = new Message();
//                        message.what = 4;
//                        message.obj = response.toString();
//                        Log.d("zenmehuishi", response.toString());
//                        handler.sendMessage(message);
//                    }
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//          }
//
//       }).start();//这个start()方法不要忘记了
//    }
//
//}
