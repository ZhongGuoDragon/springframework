package com.tom.spitter.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SpittlesForm {
    private int count;
    private long id;
    private String message;
    private Date time;
    private double longitude;
    private double latitude;
}
