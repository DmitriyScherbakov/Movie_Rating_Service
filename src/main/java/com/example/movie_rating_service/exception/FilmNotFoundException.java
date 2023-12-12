package com.example.movie_rating_service.exception;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String s) {
        super(s);
    }
}
