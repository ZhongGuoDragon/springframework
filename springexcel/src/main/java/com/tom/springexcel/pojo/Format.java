package com.tom.springexcel.pojo;

import java.util.Date;

public class Format {
    private String zh;
    private String mm;
    private String grwz;
    private String sr;
    private String hys;
    private String ipdz;
    private String zcsj;
    private String zhhc;
    private Date addtime;

    public Format() {

    }

    public Format(String zh, String mm, String grwz, String sr, String hys, String ipdz, String zcsj, String zhhc, Date addtime) {
        this.zh = zh;
        this.mm = mm;
        this.grwz = grwz;
        this.sr = sr;
        this.hys = hys;
        this.ipdz = ipdz;
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

