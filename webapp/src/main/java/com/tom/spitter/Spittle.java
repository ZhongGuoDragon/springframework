package com.tom.spitter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class Spittle {
    @Size(min=2,max=3,message = "id.wrong")
    @NotNull
    private  Long id;
    @NotNull
    @Email(message = "message.wrong")
    private String message;
    @NotNull(message = "tiem.wrong")
    private  Date time;
    @NotNull
    @Size(min=2,max=3,message = "latitude.wrong")
    private Double latitude;
    @NotNull
    @Size(min = 2, max = 3, message = "longitude.wrong")
    private Double longitude;

//    public Spittle(Long id,String message, Date time) {
//        this(id,message,time,0.0,0.0);
//    }
//
    public Spittle() {
//        this(0l, "123", new Date(), 0.0, 00.00);
    }
//
//
//
    public Spittle(long id,String message, Date time, Double longitude, Double latitude) {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//        };
        this.id = id;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
