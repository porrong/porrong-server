package com.syxxn.porrongserver.exception;

import com.syxxn.porrongserver.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends GlobalException {

    public static final NotFoundException USER_NOT_FOUND = new NotFoundException("User Not Found.");

    public static final NotFoundException LETTER_NOT_FOUND = new NotFoundException("Letter Not Found.");

    private NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

}
