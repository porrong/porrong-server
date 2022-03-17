package com.syxxn.porrongserver.feign.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthRequest {

    private final String grantType = "authorization_code";

    private final String clientId;

    private final String redirectUri;

    private final String code;

    private final String clientSecret;

    @Builder
    public AuthRequest(String clientId, String redirectUri, String code, String clientSecret) {
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.code = code;
        this.clientSecret = clientSecret;
    }

}
