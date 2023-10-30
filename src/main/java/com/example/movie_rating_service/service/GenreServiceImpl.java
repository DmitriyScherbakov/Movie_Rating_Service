package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Genre;
import com.example.movie_rating_service.repositories.GenreRepository;
import com.example.movie_rating_service.service.serviceInterfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(long id) {
        Optional<Genre> foundGenre = genreRepository.findById(id);
        return foundGenre.orElse(null);
    }

    @Transactional
    @Override
    public void createGenre(Genre genre) { genreRepository.save(genre);
    }

    @Transactional
    @Override
    public void updateGenre(Long id, Genre updatedGenre) {
        updatedGenre.setGenreId(id);
        genreRepository.save(updatedGenre);
    }

    @Transactional
    @Override
    public void deleteGenreById(long id) {
        genreRepository.deleteById(id);
    }
}
