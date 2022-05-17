package com.syxxn.porrongserver.presentation;

import com.syxxn.porrongserver.presentation.dto.request.WriteLetterRequest;
import com.syxxn.porrongserver.presentation.dto.response.GetLetterDetailsResponse;
import com.syxxn.porrongserver.presentation.dto.response.GetLetterListResponse;
import com.syxxn.porrongserver.service.letter.DeleteLetterService;
import com.syxxn.porrongserver.service.letter.GetLetterDetailsService;
import com.syxxn.porrongserver.service.letter.GetLetterListService;
import com.syxxn.porrongserver.service.letter.WriteLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/letter")
@RestController
public class LetterController {

    private final DeleteLetterService deleteLetterService;

    private final GetLetterDetailsService getLetterDetailsService;

    private final WriteLetterService writeLetterService;

    private final GetLetterListService getLetterListService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{letter_id}")
    public void deleteLetter(@PathVariable("letter_id") long letterId) {
        deleteLetterService.execute(letterId);
    }

    @GetMapping("/{letter_id}")
    public GetLetterDetailsResponse getLetterDetails(@PathVariable("letter_id") long letterId) {
        return getLetterDetailsService.execute(letterId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void writeLetter(@RequestBody @Valid WriteLetterRequest request) {
        writeLetterService.execute(request);
    }

    @GetMapping
    public GetLetterListResponse getLetterList() {
        return getLetterListService.execute();
    }

}
