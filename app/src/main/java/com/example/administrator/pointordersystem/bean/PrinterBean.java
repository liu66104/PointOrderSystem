package com.example.administrator.pointordersystem.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */

public class PrinterBean {

    /**
     * typename : [{"name":"小菜"},{"name":"饮料"}]
     * ip : 192.168.1.200
     */

    private String ip;
    private List<TypenameBean> typename;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<TypenameBean> getTypename() {
        return typename;
    }

    public void setTypename(List<TypenameBean> typename) {
        this.typename = typename;
    }

    public static class TypenameBean {
        /**
         * name : 小菜
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
