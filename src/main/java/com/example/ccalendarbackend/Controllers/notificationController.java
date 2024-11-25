package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import com.example.ccalendarbackend.Services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notifications")
@Tag(
        name="Notification Controller",
        description = "Handles operations related to notifications, such as retrieving, creating, or managing notification preferences. "
)
public class notificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;
    @Operation(method = "GET", summary = "Get all notifications")
    @CrossOrigin
    @GetMapping("/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationRepository.findAll());
    }

        @Operation(method = "POST",summary = "Create a notification",description = "Creates a new notification in the system using the provided details. The request body must include the notification's attributes, such as type, message, or associated event. Returns the created notification upon success.")
        @PostMapping
        public ResponseEntity<?> createNotification (@RequestBody Notification notificationDTO) {
            Notification notification = notificationService.createNotification(notificationDTO);
            return ResponseEntity.ok(notification);
        }

/*

    @Operation(
        summary = "Delete a notification by its ID",
        description = "This endpoint deletes a notification by its unique ID from the system.")
    @DeleteMapping("/deleteNotificationById")
    public ResponseEntity<?> deleteNotificationById () {
        return ResponseEntity.ok();
    }


    @Operation(
        summary = "Modify a notification by its ID",
        description = "This endpoint modifies an existing notification by its unique ID.")
    @PutMapping("/modifyNotificationById/{id}")
    public ResponseEntity<?> modifyNotificationById (){
        return ResponseEntity.ok()


@Operation(
        summary = "Get a list of all notifications",
        description = "This endpoint retrieves a list of all notifications in the system.")
  @GetMapping("/getNotifications")
    public ResponseEntity<?> getNotifications() {
        return ResponseEntity.ok(null);
    }

     */






}
