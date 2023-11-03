package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.repositories.ReviewRepository;
import com.example.movie_rating_service.service.serviceInterfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReviewServiceImpl {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(long id) {
        Optional<Review> foundReview = reviewRepository.findById(id);
        return foundReview.orElse(null);
    }

    @Transactional
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Transactional
    public void updateReview(Long id, Review updatedReview) {
        updatedReview.setReviewId(id);
        reviewRepository.save(updatedReview);
    }

    @Transactional
    public void deleteReviewById(long id) {
        reviewRepository.deleteById(id);
    }
}
