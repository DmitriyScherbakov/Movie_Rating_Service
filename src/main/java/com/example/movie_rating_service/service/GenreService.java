package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Genre;
import com.example.movie_rating_service.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        Optional<Genre> foundGenre = genreRepository.findById(id);
        return foundGenre.orElse(null);
    }

    @Transactional
    public void createGenre(Genre genre) { genreRepository.save(genre);
    }

    @Transactional
    public void updateGenre(Long id, Genre updatedGenre) {
        updatedGenre.setGenreId(id);
        genreRepository.save(updatedGenre);
    }

    @Transactional
    public void deleteGenreById(long id) {
        genreRepository.deleteById(id);
    }
}
