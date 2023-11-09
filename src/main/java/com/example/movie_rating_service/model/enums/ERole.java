package com.example.movie_rating_service.model.enums;

import lombok.*;

@Getter
public enum ERole {
    USER("USER"), ADMIN("ADMIN");

    private final String title;

    ERole(String title) {
        this.title = title;
    }

}
