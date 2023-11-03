package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();

    Rating getRatingById(long id);

    void createRating(Rating rating);

    void updateRating(Long id, Rating rating);

    void deleteRatingById(long id);
}
