package com.syxxn.porrongserver.facade;

import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.entity.user.repository.UserRepository;
import com.syxxn.porrongserver.exception.NotFoundException;
import com.syxxn.porrongserver.exception.UnAuthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthFacade {

    public final UserRepository userRepository;

    public User getUser() {
        return userRepository.findByEmail(getUserEmail())
                .orElseThrow(() -> NotFoundException.USER_NOT_FOUND);
    }

    private String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw UnAuthorizedException.NOT_ACCESSIBLE;
        }
        return authentication.getName();
    }


}
