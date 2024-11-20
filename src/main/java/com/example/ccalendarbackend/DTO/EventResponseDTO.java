package com.example.ccalendarbackend.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Schema(description = "Data Transfer Object for event response details, including attachments and notifications.")
public class EventResponseDTO {
    @Schema(description = "Unique identifier of the event", example = "1", required = true)
    private Long eventId;
    @Schema(description = "Title of the event", example = "Jugar al fulbo")
    private String eventTitle;
    @Schema(description = "Time of the event")
    private String eventTime;
    @Schema(description = "Day of the event in YYYY-MM-DD format", example = "2024-11-20")
    private String eventDay;
    @Schema(description = "User associated with the event", example = "tiziano10")
    private String eventUser;
    @Schema(description = "List of IDs of attachments associated with the event", example = "[1, 2, 3]")
    private List<Long> attachmentIds;
    @Schema(description = "List of URLs for attachments associated with the event", example = "[\"https://example.com/file1.pdf\", \"https://example.com/file2.png\"]")
    private List<String> attachmentUrls;
    @Schema(description = "List of notification IDs associated with the event", example = "[101, 102]")
    private List<Long> notificationIds;
    @Schema(description = "List of notification types associated with the event", example = "[Faltan 2 horas..., Falta 1 hora]")
    private List<String> notificationTypes;
}