package com.syxxn.porrongserver.entity.user.repository;

import com.syxxn.porrongserver.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
