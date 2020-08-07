package com.tom.spitter.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name="spittles")
public class Spittles {
    @Id
    private long id;

    private String message;

    private Date time;

    private double latitude;

    private double longitude;

}
