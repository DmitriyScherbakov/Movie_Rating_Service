package com.example.movie_rating_service.service;

import com.example.movie_rating_service.model.Event;
import com.example.movie_rating_service.repositories.EventRepository;
import com.example.movie_rating_service.service.serviceInterfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(long id) {
        Optional<Event> foundEvent = eventRepository.findById(id);
        return foundEvent.orElse(null);
    }

    @Transactional
    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Transactional
    @Override
    public void updateEvent(Long id, Event updatedEvent) {
        updatedEvent.setEventId(id);
        eventRepository.save(updatedEvent);
    }

    @Transactional
    @Override
    public void deleteEventById(long id) {
        eventRepository.deleteById(id);
    }
}
