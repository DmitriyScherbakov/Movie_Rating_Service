package com.example.movie_rating_service.repositories;

import com.example.movie_rating_service.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
