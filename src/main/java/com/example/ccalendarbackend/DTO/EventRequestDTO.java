package com.example.ccalendarbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequestDTO {
    private String eventTitle;
    private String eventTime;
    private String eventDate;
    private String idUser;
    private String urlAttachment;
    private int notificationId;
}





