package com.example.ccalendarbackend.DTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EventResponseDTO {
    private Long eventId;
    private String eventTitle;
    private String eventTime;
    private String eventDay;
    private String eventUser;
    private List<Long> attachmentIds;
    private List<String> attachmentUrls;
    private List<Long> notificationIds;
    private List<String> notificationTypes;
}