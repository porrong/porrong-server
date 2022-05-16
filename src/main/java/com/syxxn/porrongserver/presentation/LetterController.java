package com.syxxn.porrongserver.presentation;

import com.syxxn.porrongserver.service.letter.DeleteLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/letter")
@RestController
public class LetterController {

    private final DeleteLetterService deleteLetterService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{letter_id}")
    public void deleteLetter(@PathVariable("letter_id") long letterId) {
        deleteLetterService.execute(letterId);
    }

}
