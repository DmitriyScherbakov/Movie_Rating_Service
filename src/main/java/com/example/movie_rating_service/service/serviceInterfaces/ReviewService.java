package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.model.User;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(long id);

    void createReview(Review review);

    void updateReview(Long id, Review review);

    void deleteReviewById(long id);
}
