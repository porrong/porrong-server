package com.syxxn.porrongserver.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("oauth.kakao")
public class KakaoOAuthProperties {

    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;

    public static final String RESPONSE_TYPE = "code";

    public static final String GRANT_TYPE = "authorization_code";

    public KakaoOAuthProperties(String clientId, String clientSecret, String redirectUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }

}
