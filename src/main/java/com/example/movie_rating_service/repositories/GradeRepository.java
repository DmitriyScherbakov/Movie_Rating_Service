package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    boolean existsByUserIdAndFilmFilmId(long userId, long filmId);
}
