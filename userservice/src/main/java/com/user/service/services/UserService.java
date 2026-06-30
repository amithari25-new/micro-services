package com.user.service.services;

import com.user.service.entites.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // create user
    User create(User user);
    // get all users
    List<User> getAllUsers();

    //get user by userid
    User getUser(String userId);

}
