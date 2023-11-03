package com.example.movie_rating_service.service;

import com.example.movie_rating_service.config.UserDetailsImpl;
import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.repositories.ApplicationUserRepository;
import com.example.movie_rating_service.service.serviceInterfaces.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }

    @Override
    public ApplicationUser getUserById(long id) {
        Optional<ApplicationUser> foundUser = applicationUserRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    public void createUser(ApplicationUser user) {
        applicationUserRepository.save(user);
    }

    @Override
    public void updateUser(Long id, ApplicationUser updatedUser) {
        updatedUser.setId(id);
        applicationUserRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(long id) {
        applicationUserRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByLogin(login).
                orElseThrow(()->new UsernameNotFoundException(String.format("User '$s' not found", login)));

        return UserDetailsImpl.build(applicationUser);
    }
}
