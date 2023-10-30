package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Event;
import com.example.movie_rating_service.model.User;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEventById(long id);

    void createEvent(Event event);

    void updateEvent(Long id, Event event);

    void deleteEventById(long id);
}
