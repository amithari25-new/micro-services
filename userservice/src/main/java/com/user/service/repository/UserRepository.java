package com.user.service.repository;

import com.user.service.entites.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    //User findByUserId(String userId);
}
