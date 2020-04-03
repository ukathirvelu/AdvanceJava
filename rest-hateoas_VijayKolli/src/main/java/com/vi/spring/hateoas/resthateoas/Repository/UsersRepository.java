package com.vi.spring.hateoas.resthateoas.Repository;

import com.vi.spring.hateoas.resthateoas.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users, Long> {
}
