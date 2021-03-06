package com.syxxn.porrongserver.presentation;

import com.syxxn.porrongserver.presentation.dto.request.KakaoLoginRequest;
import com.syxxn.porrongserver.security.jwt.TokenResponse;
import com.syxxn.porrongserver.service.user.DeleteUserService;
import com.syxxn.porrongserver.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final LoginService loginService;
    private final DeleteUserService deleteUserService;

    @PostMapping
    public TokenResponse login(@RequestBody @Valid KakaoLoginRequest request) {
        return loginService.execute(request);
    }

    @DeleteMapping
    public void deleteUser() {
        deleteUserService.execute();
    }

}
