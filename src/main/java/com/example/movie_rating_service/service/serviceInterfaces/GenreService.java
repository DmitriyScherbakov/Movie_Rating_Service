package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Genre;
import com.example.movie_rating_service.model.User;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();

    Genre getGenreById(long id);

    void createGenre(Genre genre);

    void updateGenre(Long id, Genre genre);

    void deleteGenreById(long id);
}
