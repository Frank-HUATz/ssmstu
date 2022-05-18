package com.tan.util;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName ResponseMessageFactory.java
 * @Description TODO
 * @createTime 2022-05-08 11:09:00
 */
public class ResponseMessageFactory {
    public static <T> ResponseMessage<T> getResResponseMessage(ResultCode r, T data){
        return new ResponseMessage<T>(r.getStatus(),r.getMsg(),data);
    }
}
