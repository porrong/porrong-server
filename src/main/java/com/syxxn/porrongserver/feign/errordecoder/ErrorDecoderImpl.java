package com.syxxn.porrongserver.feign.errordecoder;

import com.syxxn.porrongserver.exception.BadRequestException;
import com.syxxn.porrongserver.exception.NotFoundException;
import com.syxxn.porrongserver.exception.UnAuthorizedException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorDecoderImpl implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) throws FeignException {
        if(response.status() >= 400) {
            log.info("status : " + response.status() + ", body : " + response.body());

            switch (response.status()){
                case 400:
                    return BadRequestException.EXCEPTION;
                case 401:
                    return UnAuthorizedException.EXCEPTION;
                case 404:
                    return NotFoundException.EXCEPTION;
                default:
                    return new RuntimeException(response.reason());
            }
        }
        return FeignException.errorStatus(methodKey, response);
    }

}
