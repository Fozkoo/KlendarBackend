package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import com.example.ccalendarbackend.Services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
@Tag(
        name = "Notification Controller",
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
    public ResponseEntity<?> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return ResponseEntity.ok(notifications);
    }

    @Operation(method = "POST", summary = "Create a notification", description = "Creates a new notification in the system using the provided details. The request body must include the notification's attributes, such as type, message, or associated event. Returns the created notification upon success.")
    @CrossOrigin
    @PostMapping("/createNewNotification")
    public ResponseEntity<?> createNotification(@RequestBody Notification notificationDTO) {
        Notification notification = notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok(notification);
    }

    @Operation(method = "DELETE", summary = "Delete a notification by ID", description = "Deletes a notification and its references in the intermediate table.")
    @CrossOrigin
    @DeleteMapping("/deleteNotificationById/{id}")
    public ResponseEntity<?> deleteNotificationById(@PathVariable Integer id) {
        try {
            notificationService.deleteNotificationById(id);
            return ResponseEntity.ok("Notification deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting notification: " + e.getMessage());
        }
    }


    @Operation(summary = "Modify a notification by its ID", description = "This endpoint modifies an existing notification by its unique ID.")
    @CrossOrigin
    @PutMapping("/modifyNotificationById/{id}")
    public ResponseEntity<?> modifyNotificationById(@PathVariable Integer id, @RequestBody Notification NotificationDTO) {
        Notification updatedNotification = notificationService.modifyNotificationById(id, NotificationDTO);
        if (updatedNotification != null) {
            return ResponseEntity.ok(updatedNotification);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found");
        }
    }

/*
@Operation(
        summary = "Get a list of all notifications",
        description = "This endpoint retrieves a list of all notifications in the system.")
  @GetMapping("/getNotifications")
    public ResponseEntity<?> getNotifications() {
        return ResponseEntity.ok(null);
    }

     */


    }
