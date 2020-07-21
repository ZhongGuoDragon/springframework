package com.tom.spitter.web;

public class DuplicateSpittleException extends RuntimeException{
    String message;
    public DuplicateSpittleException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
