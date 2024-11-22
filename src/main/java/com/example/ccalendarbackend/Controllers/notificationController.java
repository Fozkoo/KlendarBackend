package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import com.example.ccalendarbackend.Services.NotificationService;
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

    @GetMapping("/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<?> createNotification (@RequestBody Notification notificationDTO) {
        Notification notification = notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok(notification);
    }

/*
    public ResponseEntity<?> deleteNotificationById () {
        return ResponseEntity.ok();
    }


    public ResponseEntity<?> modifyNotificationById (){
        return ResponseEntity.ok()
    }


  @GetMapping("/getNotifications")
    public ResponseEntity<?> getNotifications() {
        return ResponseEntity.ok(null);
    }

     */



}
