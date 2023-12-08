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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePage {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;


    @GetMapping("/homepage")
    public String homePage(Model model){
        List<Film> films = filmService.getAllFilms();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("film", films);
        model.addAttribute("genre", genres);
        return "homepage";
    }

    /*@PostMapping("/homepage")
    public String homePage(Model model,@RequestParam(name = "genre", required = false) Long genre,
                             @RequestParam(name = "startYear", required = false) Integer startYear,
                             @RequestParam(name = "endYear", required = false) Integer endYear,
                             @RequestParam(name = "startRating", required = false) Double startRating,
                             @RequestParam(name = "endRating", required = false) Double endRating){
        Genre genre1 = genreService.getGenreById(genre);
        ArrayList<Film> films = filmService.findFilmsByGenresContains(genre1);
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("film", films);
        model.addAttribute("genre", genres);
        return "homepage";
    }*/
    @PostMapping("/homepage")
    public String homePage(Model model,
                           @RequestParam(name = "genre", required = false) Genre genre,
                           @RequestParam(name = "startYear", required = false) Integer startYear,
                           @RequestParam(name = "endYear", required = false) Integer endYear,
                           @RequestParam(name = "startRating", required = false) Double startRating,
                           @RequestParam(name = "endRating", required = false) Double endRating) {

        List<Film> films = filmService.findFilmsByGenresAndReleaseDateAndRating(
                genre, startYear, endYear, startRating, endRating);

        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("film", films);
        model.addAttribute("genre", genres);
        return "homepage";
    }

}
