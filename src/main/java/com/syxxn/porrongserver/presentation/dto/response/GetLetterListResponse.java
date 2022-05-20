package com.syxxn.porrongserver.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetLetterListResponse {

    private final Integer totalElements;

    private final List<LetterDto> letters;

    @Getter
    @Builder
    public static class LetterDto {
        private final Long id;
        private final Integer dDay;
        private final Boolean isReleased;
        private final String content;
    }

}
