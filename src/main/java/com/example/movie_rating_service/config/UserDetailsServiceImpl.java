package com.example.movie_rating_service.config;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.repositories.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findApplicationUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with login " + username + " not found"));
        return UserDetailsImpl.build(applicationUser);
    }
}
