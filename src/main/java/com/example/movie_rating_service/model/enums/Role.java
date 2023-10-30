package com.example.movie_rating_service.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    AUTH_USER("AUTH_USER"), UNAUTH_USER("UNAUTH_USER"), ADMIN("ADMIN");
    private final String title;

    Role(String title) {
        this.title = title;
    }

}
