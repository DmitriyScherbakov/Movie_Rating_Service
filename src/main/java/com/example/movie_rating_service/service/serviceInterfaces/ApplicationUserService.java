package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {
    List<ApplicationUser> getAllUsers();

    ApplicationUser getUserById(long id);

    void createUser(ApplicationUser user);

    void updateUser(Long id, ApplicationUser user);

    void deleteUserById(long id);
}
