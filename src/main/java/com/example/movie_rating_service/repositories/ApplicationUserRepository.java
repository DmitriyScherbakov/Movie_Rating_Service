package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional <ApplicationUser> findByLogin(String login);
}
