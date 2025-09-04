package com.college.eventregistration.controller;

import com.college.eventregistration.model.Event;
import com.college.eventregistration.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Show list of all events
    @GetMapping
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";  // returns events.html
    }

    // Show form to create a new event
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "create_event";  // returns create_event.html
    }

    // Handle form submission for creating an event
    @PostMapping
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/events";
    }

    // Show form to update an existing event
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "update_event";  // returns update_event.html
    }

    // Handle form submission for updating an event
    @PostMapping("/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events";
    }

    // Handle event deletion
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
