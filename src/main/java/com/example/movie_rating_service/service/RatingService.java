package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Rating;
import com.example.movie_rating_service.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RatingService  {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(long id) {
        Optional<Rating> foundRating = ratingRepository.findById(id);
        return foundRating.orElse(null);
    }

    @Transactional
    public void createRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Transactional
    public void updateRating(Long id, Rating updatedRating) {
        updatedRating.setRatingId(id);
        ratingRepository.save(updatedRating);
    }

    @Transactional
    public void deleteRatingById(long id) {
        ratingRepository.deleteById(id);
    }
}
