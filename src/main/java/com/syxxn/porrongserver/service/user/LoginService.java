package com.syxxn.porrongserver.service.user;

import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.entity.user.repository.UserRepository;
import com.syxxn.porrongserver.feign.KakaoAuthClient;
import com.syxxn.porrongserver.feign.KakaoInfoClient;
import com.syxxn.porrongserver.feign.dto.response.InfoResponse;
import com.syxxn.porrongserver.property.KakaoOAuthProperties;
import com.syxxn.porrongserver.security.jwt.JwtProvider;
import com.syxxn.porrongserver.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class LoginService {

    private static final String BEARER = "Bearer ";
    private static final String PROPERTY_KEYS = "[\"kakao_account.email\", \"properties.nickname\"]";

    private final KakaoOAuthProperties kakaoOAuthProperties;

    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoInfoClient kakaoInfoClient;

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    public TokenResponse execute(String code) {
        String kakaoAccessToken = getKakaoAccessToken(code);
        InfoResponse infoResponse = getKakaoAccountInfo(kakaoAccessToken);

        User user = userRepository.findByEmail(infoResponse.getKakaoAccount().getEmail())
                .orElse(saveUser(infoResponse));

        return jwtProvider.generateToken(user.getEmail());
    }

    private String getKakaoAccessToken(String code) {
        return kakaoAuthClient.execute(
                KakaoOAuthProperties.GRANT_TYPE,
                kakaoOAuthProperties.getClientId(),
                kakaoOAuthProperties.getRedirectUrl(),
                code,
                kakaoOAuthProperties.getClientSecret()
        ).getAccessToken();
    }

    private InfoResponse getKakaoAccountInfo(String accesstoken) {
        String token = BEARER + accesstoken;
        return kakaoInfoClient.execute(token, PROPERTY_KEYS);
    }

    private User saveUser(InfoResponse infoResponse) {
        String email = infoResponse.getKakaoAccount().getEmail();
        String nickname = infoResponse.getProperties().getNickname();

        return userRepository.save(
                User.createUser(email, nickname)
        );
    }

}
