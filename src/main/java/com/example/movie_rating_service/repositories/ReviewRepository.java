package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
