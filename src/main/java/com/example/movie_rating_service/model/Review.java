package com.example.movie_rating_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
//@IdClass(ReviewId.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "film_id", unique = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = false)
    private ApplicationUser user;

    @Column(name = "header_of_review", nullable = false, length = 100)
    private String header;

    @Column(name = "review", nullable = false, length = 2000)
    private String review;
}
