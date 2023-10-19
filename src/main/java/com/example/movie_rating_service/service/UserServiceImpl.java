package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Transactional
    @Override
    public List<User> get() {
        return null;
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return null;
    }

    @Transactional
    @Override
    public void createUser(User user) {

    }

    @Transactional
    @Override
    public void updateUser(User user) {

    }

    @Transactional
    @Override
    public void deleteUser(long id) {

    }
}
