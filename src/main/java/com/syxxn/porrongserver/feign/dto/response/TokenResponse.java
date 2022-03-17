package com.syxxn.porrongserver.feign.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {

    private String tokenType;

    private String accessToken;

    private String expiresIn;

    private String refreshToken;

    private String refreshTokenExpiresIn;

}
