package com.example.movie_rating_service.DAO;

import com.example.movie_rating_service.model.User;

import java.util.List;

public interface UserDAO {

    List<User> get();

    User getUserById(long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
