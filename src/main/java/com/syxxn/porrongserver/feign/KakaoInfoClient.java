package com.syxxn.porrongserver.feign;

import com.syxxn.porrongserver.feign.dto.response.InfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "KakaoInfo", url = "https://kapi.kakao.com/v2/user/me")
public interface KakaoInfoClient {

    @GetMapping
    InfoResponse execute(@RequestHeader("Authorization") String token,
                         @RequestParam("property_keys") String propertyKeys);

}
