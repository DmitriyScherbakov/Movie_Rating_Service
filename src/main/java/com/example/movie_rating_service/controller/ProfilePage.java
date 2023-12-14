package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.service.ApplicationUserService;
import com.example.movie_rating_service.service.GradeService;
import com.example.movie_rating_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
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


    @GetMapping("/profile")
    public String showUserProfile(Model model, Principal principal) {
        String username = principal.getName();
        Long userId = applicationUserService.findUserIdByUsername(username);
        ApplicationUser user = applicationUserService.getUserById(userId);

        // Получаем только рецензии текущего пользователя
        List<Review> userReviews = reviewService.getReviewsByUserId(userId);

        // Получаем все оценки пользователя (предполагается, что у вас есть сервис для получения оценок по userId)
        List<Grade> userGrades = gradeService.getGradesByUserId(userId);


        model.addAttribute("review", userReviews);
        model.addAttribute("grade", userGrades);
        return "profile-page";
    }
}
