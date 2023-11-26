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
public class HomePage {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/homepage")
    public String homePage(Model model){
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("film", films);  // исправлено название атрибута
        return "homepage";
    }


}
