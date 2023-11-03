package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser getUserById(long id) {
        Optional<ApplicationUser> foundUser = applicationUserRepository.findById(id);
        return foundUser.orElse(null);
    }

    public void createUser(ApplicationUser user) {
        applicationUserRepository.save(user);
    }

    public void updateUser(Long id, ApplicationUser updatedUser) {
        updatedUser.setId(id);
        applicationUserRepository.save(updatedUser);
    }

    public void deleteUserById(long id) {
        applicationUserRepository.deleteById(id);
    }

}
