package com.example.administrator.pointordersystem.bean;

/**
 * Created by Administrator on 2017/3/14.
 */

public class LoginBean {

    /**
     * msg : 1
     * code : 1
     */

    private String msg;
    private int code;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
