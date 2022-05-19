package com.syxxn.porrongserver.service.user;

import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.entity.user.repository.UserRepository;
import com.syxxn.porrongserver.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class DeleteUserService {

    private final UserRepository userRepository;
    private final LetterRepository letterRepository;

    private final AuthFacade authFacade;

    public void execute() {
        User user = authFacade.getUser();
        letterRepository.deleteAllByUser(user);
        userRepository.delete(user);
    }

}
