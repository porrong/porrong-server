package com.syxxn.porrongserver.feign.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InfoResponse {

    private Long id;

    private properties properties;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class properties {
        private String nickname;
    }

}
