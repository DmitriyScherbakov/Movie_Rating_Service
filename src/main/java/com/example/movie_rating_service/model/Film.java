package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

    @Column(name = "trailer_url", nullable = false, length = 100)
    private String trailerUrl;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "director", nullable = false, length = 45)
    private String director;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "duration", nullable = false)
    private long duration;

    @Column(name = "average_rating", nullable = false)
    private double averageRating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_likes",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ApplicationUser> users;

    @OneToMany(mappedBy = "film")
    private Set<Grade> grades;

    @OneToMany(mappedBy = "film")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "films_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres ;

    public void addUserWhoLikedFilm(ApplicationUser user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }
}
