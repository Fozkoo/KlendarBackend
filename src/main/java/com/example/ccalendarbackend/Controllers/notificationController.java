package com.example.ccalendarbackend.Controllers;


import com.example.ccalendarbackend.Models.Notification;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@Tag(
        name="Notification Controller",
        description = "Handles operations related to notifications, such as retrieving, creating, or managing notification preferences. "
)
public class notificationController {

    /*

    public ResponseEntity<?> getNotifications() {
        return ResponseEntity.ok();
    }

    public ResponseEntity<?> deleteNotificationById () {
        return ResponseEntity.ok();
    }


    public ResponseEntity<?> modifyNotificationById (){
        return ResponseEntity.ok()
    }

    public ResponseEntity<?> createNotification (){
        return ResponseEntity.ok()
    }


     */



}
