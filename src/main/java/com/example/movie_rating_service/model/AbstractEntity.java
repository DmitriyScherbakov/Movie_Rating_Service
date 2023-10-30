package com.example.movie_rating_service.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AbstractEntity {
    private Long id;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public AbstractEntity() {
    }
}
