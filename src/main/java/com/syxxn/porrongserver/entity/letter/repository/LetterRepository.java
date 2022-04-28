package com.syxxn.porrongserver.entity.letter.repository;

import com.syxxn.porrongserver.entity.letter.Letter;
import com.syxxn.porrongserver.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface LetterRepository extends CrudRepository<Letter, Long> {
    void deleteAllByUser(User user);
}
