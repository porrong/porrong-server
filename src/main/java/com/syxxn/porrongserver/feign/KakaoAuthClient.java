package com.syxxn.porrongserver.feign;

import com.syxxn.porrongserver.feign.dto.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "KakaoAuth", url = "https://kauth.kakao.com")
public interface KakaoAuthClient {

    @PostMapping("/oauth/token")
    TokenResponse execute(@RequestParam("grant_type") String grantType,
                          @RequestParam("client_id") String clientId,
                          @RequestParam("redirect_uri") String redirectUri,
                          @RequestParam("code") String code,
                          @RequestParam("client_secret") String clientSecret);

}
