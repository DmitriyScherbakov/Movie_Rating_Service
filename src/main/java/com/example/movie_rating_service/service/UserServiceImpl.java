package com.example.movie_rating_service.service;

import com.example.movie_rating_service.DAO.DAOInterfaces.UserDAO;
import com.example.movie_rating_service.model.User;
import com.example.movie_rating_service.service.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        userDAO.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);
    }
}
