package com.syxxn.porrongserver.security.auth;

import com.syxxn.porrongserver.entity.user.repository.UserRepository;
import com.syxxn.porrongserver.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userRepository.findByEmail(username)
                .orElseThrow(() -> NotFoundException.USER_NOT_FOUND);

        return new AuthDetails(username);
    }

}
