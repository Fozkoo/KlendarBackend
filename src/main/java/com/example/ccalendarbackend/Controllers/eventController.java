package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import com.example.ccalendarbackend.Services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Retrieve all events",
            description = "Fetches a complete list of all events stored in the database. The response includes all event details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of events",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "[{\"id\":1,\"title\":\"Event 1\",\"date\":\"2024-11-19\"}, {\"id\":2,\"title\":\"Event 2\",\"date\":\"2024-11-20\"}]"
                            ))),
            @ApiResponse(responseCode = "500", description = "Internal server error while retrieving events",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<?> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }


    @CrossOrigin
    @GetMapping("/user/{userId}")
    @Operation(
            summary = "Retrieve events by user ID",
            description = "Fetches a list of events associated with a specific user ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the events for the user",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No events found for the specified user ID",
                    content = @Content(mediaType = "application/json"))

    })
    public List<Event> getEventsByUserId(@PathVariable  @Parameter(description = "The ID of the user whose events are to be retrieved")String userId) {
        return eventService.getEventsByUserId(userId);
    }

    @CrossOrigin
    @GetMapping("/getAllInfoEvents")
    @Operation(
            summary = "Retrieve detailed event information",
            description = "Fetches a list of all events with additional details in a DTO format."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the detailed event information"),
            @ApiResponse(responseCode = "500", description = "Internal server error while retrieving event details")
    })
    public ResponseEntity<?> getAllInfoEvents(){
        List<EventResponseDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


}
