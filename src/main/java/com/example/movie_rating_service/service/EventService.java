package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Event;
import com.example.movie_rating_service.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    public Event getEventById(long id) {
        Optional<Event> foundEvent = eventRepository.findById(id);
        return foundEvent.orElse(null);
    }

    @Transactional
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Transactional
    public void updateEvent(Long id, Event updatedEvent) {
        updatedEvent.setEventId(id);
        eventRepository.save(updatedEvent);
    }

    @Transactional
    public void deleteEventById(long id) {
        eventRepository.deleteById(id);
    }
}
