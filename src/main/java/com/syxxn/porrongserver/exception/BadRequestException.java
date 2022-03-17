package com.syxxn.porrongserver.exception;

import com.syxxn.porrongserver.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends GlobalException {

    private BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

}
