package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Film;
import com.example.movie_rating_service.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    ArrayList<Film>findFilmsByGenresContains(Genre genre);
}
