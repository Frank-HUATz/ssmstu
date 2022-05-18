package com.tan.util.exeption;

public class ClassNameDuplicateException extends RuntimeException{
    public ClassNameDuplicateException(String message) {
        super(message);
    }

    public ClassNameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNameDuplicateException(Throwable cause) {
        super(cause);
    }
}
