package com.womencancode.projetofinal.repository;

import com.womencancode.projetofinal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserName(String username);

    Optional<User> findByNameIgnoreCase(String name);
}
