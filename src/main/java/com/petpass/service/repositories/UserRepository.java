package com.petpass.service.repositories;

import com.petpass.service.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
