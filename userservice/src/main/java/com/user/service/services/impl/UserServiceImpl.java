package com.user.service.services.impl;

import com.user.service.entites.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserRepository;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;

    @Override
    public User create(User user) {
        // String randomUserId = UUID.randomUUID().toString();
        //user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+userId));
    }
}
