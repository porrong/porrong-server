package com.syxxn.porrongserver.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteLetterRequest {

    @Length(min = 2, max = 16000)
    @NotBlank
    private String content;

    @Length(max = 30)
    @NotBlank
    private String dear;

    @Email
    @Length(min = 3, max = 45)
    @NotBlank
    private String email;

    @NotNull
    private LocalDate releaseDate;

}
