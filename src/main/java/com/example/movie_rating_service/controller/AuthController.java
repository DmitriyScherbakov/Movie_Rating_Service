package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.repositories.ApplicationUserRepository;
import com.example.movie_rating_service.service.ApplicationUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private ApplicationUserRepository applicationUserRepository;

    private ApplicationUserService applicationUserService;

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("ApplicationUser", new ApplicationUser());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("ApplicationUser") @Valid ApplicationUser applicationUser, Model model) {
        applicationUserService.createUser(applicationUser);
        return "redirect:/signin";
    }

}
