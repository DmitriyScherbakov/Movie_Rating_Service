package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
