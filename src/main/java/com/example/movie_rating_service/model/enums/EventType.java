package com.example.movie_rating_service.model.enums;

public enum EventType {
    LIKE("LIKE"), REVIEW("REVIEW"), GRADE("GRADE");
    private final String title;

    EventType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
