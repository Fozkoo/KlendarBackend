package com.example.ccalendarbackend.Controllers;

import com.example.ccalendarbackend.DTO.EventRequestDTO;
import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.DTO.EventUpdateRequest;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import com.example.ccalendarbackend.Services.EventService;
import com.sun.jdi.request.EventRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(
        name = "Event controller",
        description = "This controller manages operations related to events, including retrieving events by user, creating new events, and listing all available events. It facilitates interaction with the database using specialized services and DTOs for more efficient management."
)
public class eventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Operation(summary = "Get all events", description = "Retrieve a list of all available events.")
    @CrossOrigin
    @GetMapping("/getAllEvents")
    public ResponseEntity<?> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }

    @Operation(method = "GET", summary = "Get all events by user ID", description = "Retrieve a list of all events associated with a specific user based on their unique user ID. This endpoint returns event details in a structured format.")
    @CrossOrigin
    @GetMapping("/getAllEventByIdUser/{idUser}")//New endpoint
    public ResponseEntity<List<EventResponseDTO>> getAllEventsByUser(@PathVariable String idUser) {
        List<EventResponseDTO> events = eventService.getAllEventsByIdUser(idUser);
        return ResponseEntity.ok(events);
    }


    @Operation(method = "POST", summary = "Create an event", description = "Create a new event with the provided details.")
    @CrossOrigin
    @PostMapping("/createEvent")
    public ResponseEntity<?> createEvent(@RequestBody EventRequestDTO eventRequest) {
        LocalTime parsedHora = LocalTime.parse(eventRequest.getEventTime());
        LocalDate parsedDay = LocalDate.parse(eventRequest.getEventDate());
        return eventService.createEventWithDetails(
                eventRequest.getEventTitle(),
                parsedHora,
                parsedDay,
                eventRequest.getIdUser(),
                eventRequest.getUrlAttachment(),
                eventRequest.getNotificationId()
        );
    }

    @Operation(method = "DELETE", summary = "Delete an event by ID", description = "Deletes an event along with its related notifications and attachments.")
    @CrossOrigin
    @DeleteMapping("/deleteEventById/{eventId}")
    public ResponseEntity<?> deleteEventById(@PathVariable Integer eventId) {
        try {
            boolean isDeleted = eventService.deleteEventWithDependencies(eventId);
            if (isDeleted) {
                return ResponseEntity.ok("Event deleted successfully.");
            } else {
                return ResponseEntity.badRequest().body("Event not found or could not be deleted.");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }


    }

    /*

    @Operation(method = "PUT", summary = "Modify event by ID", description = "Update the details of an existing event by providing its unique ID and the new values. This endpoint allows modifying attributes such as title, time, date, and related attachments or notifications.")
    public ResponseEntity<?> modifyEventById(){
    }


    @Operation(method = "DELETE", summary = "Delete a event by ID", description = "Deletes a specific event identified by its ID from the database. Associated attachments and notifications will also be removed. Ensure the ID is valid before making this request.")
    public ResponseEntity<?> deleteEventById(){
            @CrossOrigin
    @DeleteMapping("/deleteEventById/{idEvent}")
    }


     */


    @PutMapping("update/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable Integer id,
                                            @RequestBody EventUpdateRequest request) {
        eventService.updateEventDetails(id, request.getTitle(), request.getHora(),
                request.getDay(), request.getNotificationId(),
                request.getNewUrl());
        return ResponseEntity.ok().build();
    }







}
