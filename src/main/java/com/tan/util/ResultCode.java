package com.tan.util;

public enum ResultCode {
    SUCCESS(200,"ok"),
    SUCCESS_ADD(200, "添加成功"),
    FAILURE_DUPLICATE_CLASSNAME(101, "班级名重复")
    ;
    private int status;
    private String msg;

    ResultCode(int status, String msg) {
        this.status=status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
