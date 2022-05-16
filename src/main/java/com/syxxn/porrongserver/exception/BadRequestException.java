package com.syxxn.porrongserver.exception;

import com.syxxn.porrongserver.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends GlobalException {

    public static final BadRequestException EXCEPTION = new BadRequestException();

    public static final BadRequestException LOCKED_LETTER = new BadRequestException("Unable to open the letter.");

    private BadRequestException() {
        super(HttpStatus.BAD_REQUEST.value(), "Bad Request.");
    }

    private BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

}
