package com.syxxn.porrongserver.exception.handler;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private final int statusCode;
    private final String message;

    protected GlobalException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

}
