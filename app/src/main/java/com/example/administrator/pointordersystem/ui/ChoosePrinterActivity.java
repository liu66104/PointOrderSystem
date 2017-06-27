//package com.example.administrator.pointordersystem.ui;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.administrator.pointordersystem.R;
//
//import org.xutils.view.annotation.ContentView;
//import org.xutils.view.annotation.ViewInject;
//import org.xutils.x;
//
///**
// * Created by Administrator on 2017/3/24.
// */
//@ContentView(R.layout.activity_choose)
//public class ChoosePrinterActivity extends AppCompatActivity {
//    @ViewInject(R.id.bt_printer)
//    private Button bt_printer;
//    @ViewInject(R.id.et_printer_num)
//    private TextView et_printer_num;
//
//    @ViewInject(R.id.btn_set_add)
//    private Button btn_add;
//    @ViewInject(R.id.btn_set_reduce)
//    private Button btn_reduce;
//    //    @ViewInject(R.id.bt_delete_printer)
////    private Button btn_delete;
//    @ViewInject(R.id.btn_go)
//    private Button btn_go;
//    private String num;
//    @ViewInject(R.id.btn_delete)
//    private Button btn_delete;
//    @ViewInject(R.id.btn_save_floor)
//    private Button btn_save_floor;
//    @ViewInject(R.id.et_floor)
//    private EditText et_floor;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        x.view().inject(this);
//
//        SharedPreferences sp = getSharedPreferences("wifi_printer", MODE_PRIVATE);
//        try {
//            int printerNum = sp.getInt("printerNum", 0);
//            et_printer_num.setText(printerNum + "");
//        } catch (Exception e) {
//            et_printer_num.setText(0 + "");
//        }
//
//
//
//        bt_printer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                num = et_printer_num.getText().toString();
//                int a = Integer.parseInt(num);
//
//                if (a > 0) {
//                    SharedPreferences sp = getSharedPreferences("wifi_printer", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putInt("printerNum", a);
//                    editor.commit();
//                    Intent intent = new Intent(ChoosePrinterActivity.this, AddPrinterActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(ChoosePrinterActivity.this, "输入的台数有问题", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num = et_printer_num.getText().toString();
//                int a = Integer.parseInt(num) + 1;
//                et_printer_num.setText(a + "");
//            }
//        });
//
//        btn_reduce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num = et_printer_num.getText().toString();
//                int a = Integer.parseInt(num) - 1;
//                et_printer_num.setText(a + "");
//            }
//        });
//
//        btn_go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent  = new Intent(ChoosePrinterActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sp = getSharedPreferences("wifi_printer", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putInt("printerNum", 0);
//                editor.commit();
//            }
//        });
//
//
//        btn_save_floor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String floor = et_floor.getText().toString();
//                if (floor.trim().equals("")){
//                    Toast.makeText(ChoosePrinterActivity.this, "输入楼层不能为空", Toast.LENGTH_SHORT).show();
//                }else {
//                    SharedPreferences sp = getSharedPreferences("wifi_printer", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString("floorNum", floor);
//                    editor.commit();
//                }
//            }
//        });
//
//
//    }
//}
