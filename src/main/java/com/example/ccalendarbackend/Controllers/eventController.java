package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import com.example.ccalendarbackend.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class eventController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    @CrossOrigin
    @GetMapping("/getAllEvents")
    public ResponseEntity<?> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }


    @CrossOrigin
    @GetMapping("/user/{userId}")
    public List<Event> getEventsByUserId(@PathVariable String userId) {
        return eventService.getEventsByUserId(userId);
    }

    @CrossOrigin
    @GetMapping("/getAllInfoEvents")
    public ResponseEntity<?> getAllInfoEvents(){
        List<EventResponseDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


}
