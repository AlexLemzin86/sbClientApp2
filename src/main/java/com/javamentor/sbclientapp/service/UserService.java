package com.javamentor.sbclientapp.service;

import com.javamentor.sbclientapp.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
