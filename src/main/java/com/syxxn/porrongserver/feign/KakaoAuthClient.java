package com.syxxn.porrongserver.feign;

import com.syxxn.porrongserver.feign.dto.request.AuthRequest;
import com.syxxn.porrongserver.feign.dto.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "KakaoAuth", url = "https://kauth.kakao.com")
public interface KakaoAuthClient {

    @PostMapping("/oauth/token")
    TokenResponse execute(AuthRequest request);

}
