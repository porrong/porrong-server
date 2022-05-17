package com.syxxn.porrongserver.service.letter;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.facade.AuthFacade;
import com.syxxn.porrongserver.presentation.dto.request.WriteLetterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
@Service
public class WriteLetterService {

    private final LetterRepository letterRepository;

    private final AuthFacade authFacade;

    public void execute(WriteLetterRequest request) {
        User user = authFacade.getUser();

        letterRepository.save(
                Letter.createLetter(
                        request.getContent(),
                        request.getDear(),
                        request.getEmail(),
                        request.getReleasedDate()
                )
        );
    }

}
