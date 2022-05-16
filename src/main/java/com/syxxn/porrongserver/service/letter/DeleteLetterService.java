package com.syxxn.porrongserver.service.letter;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.exception.BadRequestException;
import com.syxxn.porrongserver.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
@Service
public class DeleteLetterService {

    private final LetterRepository letterRepository;

    private final AuthFacade authFacade;

    public void execute(long letterId) {
        User user = authFacade.getUser();

        Letter letter = letterRepository.findById(letterId)
                .filter(l -> LocalDateTime.now().isAfter(l.getReleaseDate()))
                .orElseThrow(() -> {
                    throw BadRequestException.LOCKED_LETTER;
                });

        letterRepository.delete(letter);
    }

}
