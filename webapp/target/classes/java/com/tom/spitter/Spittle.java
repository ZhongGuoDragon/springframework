package com.tom.spitter;

import sun.security.provider.ConfigFile;

import java.util.Date;


public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
        this(message,time,0.0,0.0);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude) {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//        };
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public boolean equals(Object that) {
        if (that instanceof Spittle) {
            Spittle th = (Spittle) that;
            if (th.id == this.id && th.time == this.time) {
                return true;
            }
        }
        return false;
    }

}
