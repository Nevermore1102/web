package com.dao;

public class daoException extends Exception {
    private static final long serialVersionUID = 19192L;
    private String message;
    public daoException() {}
    public daoException(String message) {
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message=message;
    }
    public String toString() {
        return message;
    }
}
