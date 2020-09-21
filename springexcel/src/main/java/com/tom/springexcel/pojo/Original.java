package com.tom.springexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class Original {
    @ExcelProperty(index = 0)
    private String data;

    private Date addtime;

    public Original() {
        this(null, new Date());
    }

    public Original(String data, Date addtime) {
        this.data = data;
        this.addtime = addtime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public String getData() {
        return data;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Original{" +
                "data='" + data + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
