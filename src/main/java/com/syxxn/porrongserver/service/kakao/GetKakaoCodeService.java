package com.syxxn.porrongserver.service.kakao;

import com.syxxn.porrongserver.feign.KakaoCodeClient;
import com.syxxn.porrongserver.presentation.dto.response.KakaoCodeResponse;
import com.syxxn.porrongserver.property.KakaoOAuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetKakaoCodeService {

    private final KakaoCodeClient kakaoCodeClient;
    private final KakaoOAuthProperties kakaoOAuthProperties;

    public KakaoCodeResponse execute() {
        String code = kakaoCodeClient.execute(
                kakaoOAuthProperties.getClientId(),
                kakaoOAuthProperties.getRedirectUrl(),
                KakaoOAuthProperties.RESPONSE_TYPE);
        return new KakaoCodeResponse(code);
    }

}
