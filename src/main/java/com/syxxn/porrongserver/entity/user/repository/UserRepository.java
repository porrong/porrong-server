package com.syxxn.porrongserver.entity.user.repository;

import com.syxxn.porrongserver.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
