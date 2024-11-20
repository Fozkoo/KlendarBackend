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
    @GetMapping("/user/{idUser}")//New endpoint
    public ResponseEntity<List<EventResponseDTO>> getAllEventsByUser(@PathVariable String idUser) {
        List<EventResponseDTO> events = eventService.getAllEventsByIdUser(idUser);
        return ResponseEntity.ok(events);
    }

    @CrossOrigin
    @GetMapping("/getAllEventByIdUser/{idUser}")
    public ResponseEntity<?> getEventById(@PathVariable String idUser){
        return ResponseEntity.ok(eventRepository.getEventsByUserId(idUser));
    }
}
