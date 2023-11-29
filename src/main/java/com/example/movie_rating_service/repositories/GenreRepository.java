package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
