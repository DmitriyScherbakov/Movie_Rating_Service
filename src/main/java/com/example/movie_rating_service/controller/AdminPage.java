package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.service.ApplicationUserService;
import com.example.movie_rating_service.service.FilmService;
import com.example.movie_rating_service.service.GradeService;
import com.example.movie_rating_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminPage {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private FilmService filmService;

    @GetMapping("/adminPage")
    public String showUserProfile(Model model, Principal principal) {
        List<ApplicationUser> users = applicationUserService.getAllUsers();
        List<Film> films = filmService.getAllFilms();

        model.addAttribute("films", films);
        model.addAttribute("users", users);
        return "admin-page";
    }
}
