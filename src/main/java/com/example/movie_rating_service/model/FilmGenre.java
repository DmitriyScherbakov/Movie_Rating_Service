package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@IdClass(FilmGenreId.class)
@Table(name = "films_genres")
public class FilmGenre {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
