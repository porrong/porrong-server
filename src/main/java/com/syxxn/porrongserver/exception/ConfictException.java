package com.syxxn.porrongserver.exception;

import com.syxxn.porrongserver.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class ConfictException extends GlobalException {

    public static final ConfictException ACCOUNT_ALREADY_EXISTS = new ConfictException("Account's Email Already Exists.");

    private ConfictException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }

}
