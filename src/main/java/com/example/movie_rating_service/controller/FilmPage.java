package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.*;
import com.example.movie_rating_service.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class FilmPage {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/film/{filmId}")
    public String getFilmDetails(@PathVariable Long filmId, Model model, HttpServletRequest request) {
        Film film = filmService.getFilmById(filmId);
        List<Genre> genres = genreService.getAllGenres();
        Optional<Review> reviews = reviewService.getReviewsByFilmId(filmId);


        // Добавьте объект HttpServletRequest в модель
        model.addAttribute("httpServletRequest", request);

        model.addAttribute("review", reviews);
        model.addAttribute("film", film);
        model.addAttribute("genre", genres);
        return "film-details";
    }


    @PostMapping("/likeMovie")
    public ResponseEntity<String> likeMovie(@RequestParam long filmId, @RequestParam long userId) {
        Film film = filmService.getFilmById(filmId);
        ApplicationUser user = applicationUserService.getUserById(userId);

        if (film != null && user != null) {
            film.addUserWhoLikedFilm(user);
            filmService.createFilm(film); // Save the updated film with the new like
            return new ResponseEntity<>("Movie liked successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error liking the movie.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submitGrade")
    public ResponseEntity<String> submitGrade(
            @RequestBody Map<String, Object> payload) {

        try {
            long userId = Long.parseLong(payload.get("userId").toString());
            long filmId = Long.parseLong(payload.get("filmId").toString());
            double gradeByUser = Double.parseDouble(payload.get("gradeByUser").toString());

            if (gradeService.hasUserAlreadyRatedFilm(userId, filmId)) {
                System.out.println("User has already rated the film.");
                return new ResponseEntity<>("User has already rated the film.", HttpStatus.BAD_REQUEST);
            }

            ApplicationUser user = applicationUserService.getUserById(userId);
            Film film = filmService.getFilmById(filmId);

            if (user != null && film != null) {
                Grade grade = new Grade();
                grade.setUser(user);
                grade.setFilm(film);
                grade.setGradeByUser(gradeByUser);
                gradeService.createGrade(grade);
                return new ResponseEntity<>("Grade submitted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error submitting the grade.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing the request.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String>
}

