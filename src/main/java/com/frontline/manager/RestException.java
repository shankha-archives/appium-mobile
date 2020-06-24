package com.frontline.manager;

public class RestException extends RuntimeException {
    private static final long serialVersionUID = 9102369783706142278L;

    public RestException() {}

    public RestException(String msg) {
        super(msg);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }
}