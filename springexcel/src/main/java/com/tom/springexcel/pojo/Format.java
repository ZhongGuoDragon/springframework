package com.tom.springexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class Format {
    @ExcelProperty(value = "账号",index = 0)
    private String zh;
    @ExcelProperty(value = "密码",index = 1)
    private String mm;
    @ExcelProperty(value = "个人网址",index = 2)
    private String grwz;
    @ExcelProperty(value = "生日",index = 3)
    private String sr;
    @ExcelProperty(value = "好友数",index = 4)
    private String hys;
    @ExcelProperty(value = "IP地址",index =5)
    private String ipdz;
    @ExcelProperty(value = "常用位置",index =6)
    private String cywz;
    @ExcelProperty(value = "注册时间",index = 7)
    private String zcsj;
    @ExcelProperty(value = "账号缓存",index =8)
    private String zhhc;
    private Date addtime;

    public Format() {
        addtime = new Date();

    }

    public Format(String zh, String mm, String grwz, String sr, String hys, String ipdz, String cywz,String zcsj, String zhhc, Date addtime) {
        this.zh = zh;
        this.mm = mm;
        this.grwz = grwz;
        this.sr = sr;
        this.hys = hys;
        this.ipdz = ipdz;
        this.cywz = cywz;
        this.zcsj = zcsj;
        this.zhhc = zhhc;
        this.addtime = addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public String getGrwz() {
        return grwz;
    }

    public String getHys() {
        return hys;
    }

    public String getIpdz() {
        return ipdz;
    }

    public String getMm() {
        return mm;
    }

    public String getSr() {
        return sr;
    }

    public String getZh() {
        return zh;
    }

    public String getZcsj() {
        return zcsj;
    }

    public String getCywz() {
        return cywz;
    }


    public String getZhhc() {
        return zhhc;
    }

    public void setGrwz(String grwz) {
        this.grwz = grwz;
    }

    public void setHys(String hys) {
        this.hys = hys;
    }

    public void setIpdz(String ipdz) {
        this.ipdz = ipdz;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public void setCywz(String cywz) {
        this.cywz = cywz;
    }

    public void setZcsj(String zcsj) {
        this.zcsj = zcsj;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public void setZhhc(String zhhc) {
        this.zhhc = zhhc;
    }

    @Override
    public String toString() {
        return "Format{" +
                "zh='" + zh + '\'' +
                ", mm='" + mm + '\'' +
                ", grwz='" + grwz + '\'' +
                ", sr='" + sr + '\'' +
                ", hys='" + hys + '\'' +
                ", ipdz='" + ipdz + '\'' +
                ", zcsj='" + zcsj + '\'' +
                ", zhhc='" + zhhc + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}

