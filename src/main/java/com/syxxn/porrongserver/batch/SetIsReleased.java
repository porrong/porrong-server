package com.syxxn.porrongserver.batch;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.letter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class SetIsReleased {

    private final LetterRepository letterRepository;

    @Transactional
    @Scheduled(cron = "0 17 13 * * *") // 초 분 시 일 월 요일
    public void setIsReleased() {
        letterRepository.findAllByReleaseDateGreaterThanEqual(LocalDate.now())
                .forEach(Letter::isReleasedTrue);
    }

}
