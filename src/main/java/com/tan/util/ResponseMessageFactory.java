package com.tan.util;
public class ResponseMessageFactory {
    public static <T> ResponseMessage<T> getResResponseMessage(ResultCode r, T data){
        return new ResponseMessage<T>(r.getStatus(),r.getMsg(),data);
    }
}
