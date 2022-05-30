package com.syxxn.porrongserver.service.letter;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import com.syxxn.porrongserver.entity.user.User;
import com.syxxn.porrongserver.facade.AuthFacade;
import com.syxxn.porrongserver.presentation.dto.response.GetLetterListResponse;
import com.syxxn.porrongserver.presentation.dto.response.GetLetterListResponse.LetterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetLetterListService {

    private final LetterRepository letterRepository;

    private final AuthFacade authFacade;

    public GetLetterListResponse execute() {
        User user = authFacade.getUser();

        List<Letter> letters = letterRepository.findAllByUserOrderByCreatedAtDesc(user);

        return new GetLetterListResponse(
                letters.size(),
                letters.stream().map(
                        l -> {
                            if (!l.getIsReleased()) {
                                int dDay = Period.between(LocalDate.now(), l.getReleaseDate()).getDays();

                                return LetterDto.builder()
                                        .id(l.getId())
                                        .content(null)
                                        .dDay(dDay)
                                        .isReleased(false)
                                        .build();
                            } else {
                                return LetterDto.builder()
                                        .id(l.getId())
                                        .content((l.getContent().length() > 10 ? l.getContent().substring(0, 10) : l.getContent()) + "...")
                                        .dDay(0)
                                        .isReleased(true)
                                        .build();
                            }
                        }
                ).collect(Collectors.toList())
        );
    }

}
