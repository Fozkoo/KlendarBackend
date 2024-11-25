package com.example.ccalendarbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EventUpdateRequest {
    private String title;
    private LocalTime hora;
    private LocalDate day;
    private Integer notificationId;
    private String newUrl;

    // Getters y setters
}
