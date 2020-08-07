package com.tom.mybatis.pojo;

public enum Sex {
    MALE(1,"男"),FEMALE(2,"女");
    private int id;
    private String string;

    private Sex(int id, String string) {
        this.id = id;
        this.string = string;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public static Sex getSex(int id) {
        if (id == 1) {
            return MALE;
        } else if (id == 2) {
            return FEMALE;
        } else {
            return null;
        }
    }
}
