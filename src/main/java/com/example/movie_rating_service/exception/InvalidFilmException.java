package com.example.movie_rating_service.exception;

//Тесты из ТЗ 8 пропускают код ошибки 400
//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFilmException extends RuntimeException {
    public InvalidFilmException(String message) {
        super(message);
    }
}