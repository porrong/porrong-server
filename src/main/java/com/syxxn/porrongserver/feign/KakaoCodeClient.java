package com.syxxn.porrongserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "KakaoCode", url = "https://kauth.kakao.com")
public interface KakaoCodeClient {

    @GetMapping("/oauth/authorize")
    String execute(@RequestParam("client_id") String clientId,
                   @RequestParam("redirect_uri") String redirectUri,
                   @RequestParam("response_type") String responseType);

}
