package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Genre;
import com.example.movie_rating_service.service.FilmService;
import com.example.movie_rating_service.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FilmPage {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;


    @GetMapping("/film/{filmId}")
    public String getFilmDetails(@PathVariable Long filmId, Model model) {
        Film film = filmService.getFilmById(filmId); // Implement this method in your service
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("film", film);
        model.addAttribute("genre", genres);
        return "film-details"; // Create a Thymeleaf template for displaying individual film details
    }
}
