package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUserById(long id);
}
