package com.tan.util;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName ResponseMessage.java
 * @Description TODO
 * @createTime 2022-05-08 10:50:00
 */
public class ResponseMessage<T> {

    private int status;
    private String message;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int status,String message,T data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setState(int state) {
        this.status = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
