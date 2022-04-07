package com.syxxn.porrongserver.presentation;

import com.syxxn.porrongserver.presentation.dto.response.KakaoCodeResponse;
import com.syxxn.porrongserver.service.kakao.GetKakaoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/kakao")
@RestController
public class KakaoOAuthController {

    private final GetKakaoCodeService getKakaoCodeService;

    @GetMapping("/code")
    public KakaoCodeResponse getKakaoCode() {
        return getKakaoCodeService.execute();
    }

}
