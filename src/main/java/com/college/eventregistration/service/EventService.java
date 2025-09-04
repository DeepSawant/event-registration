package com.college.eventregistration.service;

import com.college.eventregistration.model.Event;
import com.college.eventregistration.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Method to get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Method to create/save an event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        existingEvent.setName(event.getName());
        existingEvent.setDate(event.getDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDescription(event.getDescription());

        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
