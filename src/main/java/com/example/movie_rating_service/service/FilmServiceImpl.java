package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.repositories.FilmRepository;
import com.example.movie_rating_service.service.serviceInterfaces.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(long id) {
        Optional<Film> foundFilm = filmRepository.findById(id);
        return foundFilm.orElse(null);
    }

    @Transactional
    @Override
    public void createFilm(Film film) {
        filmRepository.save(film);
    }

    @Transactional
    @Override
    public void updateFilm(Long id, Film updatedFilm) {
        updatedFilm.setFilmId(id);
        filmRepository.save(updatedFilm);
    }

    @Transactional
    @Override
    public void deleteFilmById(long id) {
        filmRepository.deleteById(id);
    }
}
