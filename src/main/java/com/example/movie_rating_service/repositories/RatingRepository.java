package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
