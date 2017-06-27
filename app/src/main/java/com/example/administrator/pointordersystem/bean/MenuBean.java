package com.example.administrator.pointordersystem.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MenuBean {


    /**
     * muid : 797dd132-4cb0-4af1-853e-5a4d9b580478
     * mcid : f464117d-cbf4-456f-8014-8f20b99340d0
     * wrid : null
     * muname : 盖饭
     * muindex : 1
     * createuser : 测试店铺1总管理员
     * createtime : 1495420306
     * updateuser : null
     * updatetime : null
     * wares : [{"ptid":"46f90490-9a0b-4b9d-a350-550c7027452f","mcid":null,"ptname":"盖饭1","ptcost":null,"ptstute":null,"quantity":10,"createuser":"测试店铺1总管理员","createtime":1495420317,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"0a21d3a7-b594-498b-bf20-afc8834eae36","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":23.5,"ptdist":null,"ptdcprice":null,"boxprice":1,"imgurl":"http://192.168.1.92/oss/upload/b92b5b4f-c4c3-4029-b3f2-0ff3395bcfc6.jpeg","wstate":0,"pbcombo":[],"operation":null},{"ptid":"34dac718-4b7d-43d9-9076-cc9f78e335fa","mcid":null,"ptname":"盖饭4","ptcost":null,"ptstute":null,"quantity":10,"createuser":"测试店铺1总管理员","createtime":1495420376,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"20b59482-66d5-4130-8797-f2a85814cd27","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":38,"ptdist":null,"ptdcprice":null,"boxprice":1,"imgurl":"http://192.168.1.92/oss/upload/7f1e97da-f73f-46e1-8663-93477e47e6ae.jpg","wstate":0,"pbcombo":[],"operation":null},{"ptid":"e30dee4e-3439-4474-bf45-a8aa464397af","mcid":null,"ptname":"盖饭6","ptcost":null,"ptstute":null,"quantity":1,"createuser":"测试店铺1总管理员","createtime":1495433694,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"237c4686-a8cd-4925-9bc6-5ed2cd556d42","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":23,"ptdist":null,"ptdcprice":null,"boxprice":0,"imgurl":"http://192.168.1.92/oss/upload/14c4d4f7-4919-4e5c-9f89-dd29e29af791.jpg","wstate":0,"pbcombo":[],"operation":null},{"ptid":"aff0c7bd-b036-4b55-bc6c-f48ba662767f","mcid":null,"ptname":"盖饭3","ptcost":null,"ptstute":null,"quantity":10,"createuser":"测试店铺1总管理员","createtime":1495420356,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"9eb813a3-2a73-4c5b-a13c-3ae02faef9a9","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":12.5,"ptdist":null,"ptdcprice":null,"boxprice":1,"imgurl":"http://192.168.1.92/oss/upload/8c7415be-bca1-4c2c-9a76-c47ea22561db.jpg","wstate":0,"pbcombo":[],"operation":null},{"ptid":"0de8c8e9-6a22-490e-89ff-651fa2f446d7","mcid":null,"ptname":"盖饭2","ptcost":null,"ptstute":null,"quantity":10,"createuser":"测试店铺1总管理员","createtime":1495420341,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"e5a214a7-e1ca-4063-9e47-1ecbd1e6c12c","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":25,"ptdist":null,"ptdcprice":null,"boxprice":1,"imgurl":"http://192.168.1.92/oss/upload/4a254fdf-dc14-4d10-ad41-ade8eaa5a000.jpg","wstate":0,"pbcombo":[],"operation":null},{"ptid":"b68b0f1b-25ba-4fbb-a1a1-a9a75082a072","mcid":null,"ptname":"盖饭5","ptcost":null,"ptstute":null,"quantity":10,"createuser":"测试店铺1总管理员","createtime":1495420395,"updateuser":null,"updatetime":null,"ctime":null,"utime":null,"wrid":"f2d735bb-ff5c-4a2d-8758-347edef6ad05","muid":"797dd132-4cb0-4af1-853e-5a4d9b580478","ptprice":52,"ptdist":null,"ptdcprice":null,"boxprice":1,"imgurl":"http://192.168.1.92/oss/upload/623aa2a2-be62-4585-aaba-cb0afe2ed17d.jpg","wstate":0,"pbcombo":[],"operation":null}]
     */

    private String muid;
    private String mcid;
    private Object wrid;
    private String muname;
    private int muindex;
    private String createuser;
    private int createtime;
    private Object updateuser;
    private Object updatetime;
    private List<WaresBean> wares;

    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    public String getMcid() {
        return mcid;
    }

    public void setMcid(String mcid) {
        this.mcid = mcid;
    }

    public Object getWrid() {
        return wrid;
    }

    public void setWrid(Object wrid) {
        this.wrid = wrid;
    }

    public String getMuname() {
        return muname;
    }

    public void setMuname(String muname) {
        this.muname = muname;
    }

    public int getMuindex() {
        return muindex;
    }

    public void setMuindex(int muindex) {
        this.muindex = muindex;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public Object getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(Object updateuser) {
        this.updateuser = updateuser;
    }

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Object updatetime) {
        this.updatetime = updatetime;
    }

    public List<WaresBean> getWares() {
        return wares;
    }

    public void setWares(List<WaresBean> wares) {
        this.wares = wares;
    }

    public static class WaresBean {
        /**
         * ptid : 46f90490-9a0b-4b9d-a350-550c7027452f
         * mcid : null
         * ptname : 盖饭1
         * ptcost : null
         * ptstute : null
         * quantity : 10
         * createuser : 测试店铺1总管理员
         * createtime : 1495420317
         * updateuser : null
         * updatetime : null
         * ctime : null
         * utime : null
         * wrid : 0a21d3a7-b594-498b-bf20-afc8834eae36
         * muid : 797dd132-4cb0-4af1-853e-5a4d9b580478
         * ptprice : 23.5
         * ptdist : null
         * ptdcprice : null
         * boxprice : 1.0
         * imgurl : http://192.168.1.92/oss/upload/b92b5b4f-c4c3-4029-b3f2-0ff3395bcfc6.jpeg
         * wstate : 0
         * pbcombo : []
         * operation : null
         */

        private String ptid;
        private Object mcid;
        private String ptname;
        private Object ptcost;
        private Object ptstute;
        private int quantity;
        private String createuser;
        private int createtime;
        private Object updateuser;
        private Object updatetime;
        private Object ctime;
        private Object utime;
        private String wrid;
        private String muid;
        private double ptprice;
        private Object ptdist;
        private Object ptdcprice;
        private double boxprice;
        private String imgurl;
        private int wstate;
        private Object operation;
        private List<?> pbcombo;

        public String getPtid() {
            return ptid;
        }

        public void setPtid(String ptid) {
            this.ptid = ptid;
        }

        public Object getMcid() {
            return mcid;
        }

        public void setMcid(Object mcid) {
            this.mcid = mcid;
        }

        public String getPtname() {
            return ptname;
        }

        public void setPtname(String ptname) {
            this.ptname = ptname;
        }

        public Object getPtcost() {
            return ptcost;
        }

        public void setPtcost(Object ptcost) {
            this.ptcost = ptcost;
        }

        public Object getPtstute() {
            return ptstute;
        }

        public void setPtstute(Object ptstute) {
            this.ptstute = ptstute;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getCreateuser() {
            return createuser;
        }

        public void setCreateuser(String createuser) {
            this.createuser = createuser;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public Object getUpdateuser() {
            return updateuser;
        }

        public void setUpdateuser(Object updateuser) {
            this.updateuser = updateuser;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public Object getCtime() {
            return ctime;
        }

        public void setCtime(Object ctime) {
            this.ctime = ctime;
        }

        public Object getUtime() {
            return utime;
        }

        public void setUtime(Object utime) {
            this.utime = utime;
        }

        public String getWrid() {
            return wrid;
        }

        public void setWrid(String wrid) {
            this.wrid = wrid;
        }

        public String getMuid() {
            return muid;
        }

        public void setMuid(String muid) {
            this.muid = muid;
        }

        public double getPtprice() {
            return ptprice;
        }

        public void setPtprice(double ptprice) {
            this.ptprice = ptprice;
        }

        public Object getPtdist() {
            return ptdist;
        }

        public void setPtdist(Object ptdist) {
            this.ptdist = ptdist;
        }

        public Object getPtdcprice() {
            return ptdcprice;
        }

        public void setPtdcprice(Object ptdcprice) {
            this.ptdcprice = ptdcprice;
        }

        public double getBoxprice() {
            return boxprice;
        }

        public void setBoxprice(double boxprice) {
            this.boxprice = boxprice;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public int getWstate() {
            return wstate;
        }

        public void setWstate(int wstate) {
            this.wstate = wstate;
        }

        public Object getOperation() {
            return operation;
        }

        public void setOperation(Object operation) {
            this.operation = operation;
        }

        public List<?> getPbcombo() {
            return pbcombo;
        }

        public void setPbcombo(List<?> pbcombo) {
            this.pbcombo = pbcombo;
        }
    }
}
