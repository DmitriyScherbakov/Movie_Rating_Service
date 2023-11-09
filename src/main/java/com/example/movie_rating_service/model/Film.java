package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@EqualsAndHashCode(exclude = "likes")
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private long filmId;

    @Column(name = "film_name", unique = true, nullable = false, length = 100)
    private String filmName;

    @Column(name = "film_image_url", nullable = false, length = 200)
    private String filmImageUrl;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "director", nullable = false, length = 45)
    private String director;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "duration", nullable = false)
    private long duration;

    @Column(name = "average_rating", nullable = false)
    private double averageRating;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @ManyToMany
    @JoinTable(name = "film_likes",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ApplicationUser> users;

    @OneToMany(mappedBy = "film")
    private Set<Grade> grades;

    @OneToMany(mappedBy = "film")
    private Set<Review> reviews;

    @ManyToMany
    @JoinTable(name = "films_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres ;
}
