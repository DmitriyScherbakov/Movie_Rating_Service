package com.example.movie_rating_service.DAO.DAOInterfaces;

import com.example.movie_rating_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(long id);

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUserById(long id);
}
