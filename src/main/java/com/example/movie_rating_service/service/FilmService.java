package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Genre;
import com.example.movie_rating_service.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FilmService {

    private final FilmRepository filmRepository;

    private GenreService genreService;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }


    public Film getFilmById(long id) {
        Optional<Film> foundFilm = filmRepository.findById(id);
        return foundFilm.orElse(null);
    }

    @Transactional
    public void createFilm(Film film) {
        filmRepository.save(film);
    }

    @Transactional
    public void updateFilm(Long id, Film updatedFilm) {
        updatedFilm.setFilmId(id);
        filmRepository.save(updatedFilm);
    }

    @Transactional
    public void deleteFilmById(long id) {
        filmRepository.deleteById(id);
    }

    public ArrayList<Film> findFilmsByGenresAndReleaseDateAndRating(
            Genre genre, Integer startYear, Integer endYear, Double startRating, Double endRating) {

        Date startReleaseDate = (startYear != null) ? Date.valueOf(startYear + "-01-01") : Date.valueOf("0000-01-01");
        Date endReleaseDate = (endYear != null) ? Date.valueOf(endYear + "-12-31") : Date.valueOf("9999-12-31");
        double defaultStartRating = (startRating != null) ? startRating : 0.0;
        double defaultEndRating = (endRating != null) ? endRating : 10.0;

        if (genre == null || genre.getGenreId() == 0) {
            return filmRepository.findFilmsByReleaseDateBetweenAndAverageRatingBetween(
                    startReleaseDate, endReleaseDate, defaultStartRating, defaultEndRating);
        } else {
            return filmRepository.findFilmsByGenresContainsAndReleaseDateBetweenAndAverageRatingBetween(
                    genre, startReleaseDate, endReleaseDate, defaultStartRating, defaultEndRating);
        }
    }
}
