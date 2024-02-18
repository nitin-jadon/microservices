package com.lcwd.user.service.userservice.services;

import com.lcwd.user.service.userservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User save(User user);
    User getUser(String userId);
}
