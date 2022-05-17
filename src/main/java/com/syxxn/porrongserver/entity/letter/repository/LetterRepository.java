package com.syxxn.porrongserver.entity.letter.repository;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface LetterRepository extends CrudRepository<Letter, Long> {
    void deleteAllByUser(User user);
    List<Letter> findAllByReleaseDateGreaterThanEqual(LocalDate now);
    List<Letter> findAllByUser(User user);
}
