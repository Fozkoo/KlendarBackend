package com.example.ccalendarbackend.Controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@Tag(
        name="Notification Controller",
        description = "Handles operations related to notifications, such as retrieving, creating, or managing notification preferences. "
)
public class notificationController {



}
