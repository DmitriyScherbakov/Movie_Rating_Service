package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findReviewByFilmFilmId(long filmId);

    boolean existsByUserIdAndFilmFilmId(long userId, long filmId);
}
