package com.syxxn.porrongserver.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetLetterDetailsResponse {

    private final String dear;

    private final String content;

    private final String email;

    private final LocalDate createdAt;

    private final LocalDate releaseDate;

}
