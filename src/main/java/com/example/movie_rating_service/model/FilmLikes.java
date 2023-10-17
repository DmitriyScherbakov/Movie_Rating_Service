package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@IdClass(FilmLikeId.class)
@Table(name = "film_likes")
public class FilmLikes {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
