package com.syxxn.porrongserver.presentation;

import com.syxxn.porrongserver.security.jwt.TokenResponse;
import com.syxxn.porrongserver.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final LoginService loginService;

    @PostMapping
    public TokenResponse login(String code) {
        return loginService.execute(code);
    }

}
