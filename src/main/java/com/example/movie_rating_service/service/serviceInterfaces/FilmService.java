package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();

    Film getFilmById(long id);

    void createFilm(Film film);

    void updateFilm(Long id, Film film);

    void deleteFilmById(long id);
}
