package com.example.ccalendarbackend.Controllers;
import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import com.example.ccalendarbackend.Services.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(
        name="Event Controller",
        description = "Handles operations related to attachments, such as retrieving all available attachments."
)
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
    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<EventResponseDTO>> getAllEventsByUser(@PathVariable String idUser) {
        List<EventResponseDTO> events = eventService.getAllEventsByIdUser(idUser);
        return ResponseEntity.ok(events);
    }
    @CrossOrigin
    @GetMapping("/getEventById/{userId}")
    public ResponseEntity<?> getEventById(@PathVariable String userId){
        return ResponseEntity.ok(eventRepository.getEventsByUserId(userId));
    }
}
