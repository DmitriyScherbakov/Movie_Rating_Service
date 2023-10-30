package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Rating;
import com.example.movie_rating_service.repositories.RatingRepository;
import com.example.movie_rating_service.service.serviceInterfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(long id) {
        Optional<Rating> foundRating = ratingRepository.findById(id);
        return foundRating.orElse(null);
    }

    @Transactional
    @Override
    public void createRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Transactional
    @Override
    public void updateRating(Long id, Rating updatedRating) {
        updatedRating.setRatingId(id);
        ratingRepository.save(updatedRating);
    }

    @Transactional
    @Override
    public void deleteRatingById(long id) {
        ratingRepository.deleteById(id);
    }
}
