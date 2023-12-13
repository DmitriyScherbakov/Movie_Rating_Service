package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private long gradeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "grade_by_user", nullable = false)
    private double gradeByUser;

}
