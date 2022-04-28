package com.syxxn.porrongserver.service.kakao;

import com.syxxn.porrongserver.property.KakaoOAuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetKakaoCodeService {
    private final KakaoOAuthProperties kakaoOAuthProperties;

    public String execute() {
        return new String("https://kauth.kakao.com/oauth/authorize?client_id=?1&redirect_uri=?2&response_type=?3")
                .replace("?1", kakaoOAuthProperties.getClientId())
                .replace("?2", kakaoOAuthProperties.getRedirectUrl())
                .replace("?3", KakaoOAuthProperties.RESPONSE_TYPE);
    }

}
