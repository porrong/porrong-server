package com.syxxn.porrongserver.exception;

import com.syxxn.porrongserver.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends GlobalException {

    public static final UnAuthorizedException NOT_ACCESSIBLE = new UnAuthorizedException("User Not Accessible.");

    private UnAuthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED.value(), message);
    }

}
