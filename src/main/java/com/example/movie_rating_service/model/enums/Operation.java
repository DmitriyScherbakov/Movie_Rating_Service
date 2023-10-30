package com.example.movie_rating_service.model.enums;

import lombok.Getter;

@Getter
public enum Operation {
    REMOVE("REMOVE"), ADD("ADD"), UPDATE("UPDATE");
    private final String title;

    Operation(String title) {
        this.title = title;
    }

}
