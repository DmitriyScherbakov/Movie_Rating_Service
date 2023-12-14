package com.example.movie_rating_service.service;

import com.example.movie_rating_service.config.UserDetailsImpl;
import com.example.movie_rating_service.exception.UserNotFoundException;
import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.repositories.ApplicationUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser getUserById(long id) {
        Optional<ApplicationUser> foundUser = applicationUserRepository.findById(id);
        return foundUser.orElse(null);
    }

    public void createUser(ApplicationUser user) {
        Optional<ApplicationUser> existingUser = applicationUserRepository.findApplicationUserByLogin(user.getLogin());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Логин уже занят, пожалуйста, выберите другой.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    public Long findUserIdByUsername(String username) {
        Optional<ApplicationUser> user = applicationUserRepository.findApplicationUserByLogin(username);
        if (user.isPresent()) {
            return user.get().getId();
        } else {
            throw new UserNotFoundException("User not found with username: " + username);
        }
    }

    public String findUserPasswordById(Long userId) {
        ApplicationUser user = applicationUserRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        // Получение хеша пароля
        return user.getPassword();
    }

    public boolean checkPassword(Long userId, String rawPassword) {
        ApplicationUser user = applicationUserRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        // Сравнение введенного пароля с хешем
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
