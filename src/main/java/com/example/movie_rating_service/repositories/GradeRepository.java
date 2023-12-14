package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    boolean existsByUserIdAndFilmFilmId(long userId, long filmId);

    List<Grade> findGradesByUserId(long id);
}
