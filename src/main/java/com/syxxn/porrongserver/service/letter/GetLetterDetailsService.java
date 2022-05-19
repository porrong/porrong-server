package com.syxxn.porrongserver.service.letter;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import com.syxxn.porrongserver.exception.BadRequestException;
import com.syxxn.porrongserver.exception.NotFoundException;
import com.syxxn.porrongserver.facade.AuthFacade;
import com.syxxn.porrongserver.presentation.dto.response.GetLetterDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetLetterDetailsService {

    private final LetterRepository letterRepository;

    private final AuthFacade authFacade;

    public GetLetterDetailsResponse execute(long letterId) {
        authFacade.getUser();

        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(() -> {
                    throw NotFoundException.LETTER_NOT_FOUND;
                });

        if (letter.getReleaseDate().isAfter(LocalDate.now())) {
            throw BadRequestException.LOCKED_LETTER;
        }

        return GetLetterDetailsResponse.builder()
                .dear(letter.getDear())
                .content(letter.getContent())
                .email(letter.getEmail())
                .createdAt(letter.getCreatedAt().toLocalDate())
                .releaseDate(letter.getReleaseDate())
                .build();
    }

}
