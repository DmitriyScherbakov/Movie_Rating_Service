package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfilePage {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private FilmService filmService;

    @GetMapping("/profile")
    public String showUserProfile(Model model, Principal principal) {
        String username = principal.getName();
        Long userId = applicationUserService.findUserIdByUsername(username);
        ApplicationUser user = applicationUserService.getUserById(userId);

        List<Review> userReviews = reviewService.getReviewsByUserId(userId);
        List<Grade> userGrades = gradeService.getGradesByUserId(userId);
        List<Film> films = filmService.getAllFilms();


        List<Long> likedFilmIds = filmService.getLikedFilmIdsByUserId(userId);
        model.addAttribute("likedFilmIds", likedFilmIds);

        model.addAttribute("film", films);
        model.addAttribute("review", userReviews);
        model.addAttribute("grade", userGrades);
        return "profile-page";
    }

    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam("reviewId") String reviewId) {
        long id = Long.parseLong(reviewId);
        System.out.println("xui" + reviewId);
        reviewService.deleteReviewById(id);
        return "redirect:/profile";
    }
}
