package com.example.ccalendarbackend.Services;


import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public ResponseEntity<?> getAllEventsById(@PathVariable String idUser) {
        return  ResponseEntity.ok(eventRepository.findEventsByUserId(idUser));
    }


    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> getEventsByUserId(String userId) {
        return eventRepository.findEventsByUserId(userId);
    }



    public List<EventResponseDTO> getAllEvents() {
        List<Object[]> results = eventRepository.getAllEventsWithNotificationsAndAttachments();
        List<EventResponseDTO> events = new ArrayList<>();

        // Definir los formateadores de fecha y hora
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Object[] row : results) {
            EventResponseDTO dto = new EventResponseDTO();
            dto.setEventId(((Number) row[0]).longValue());
            dto.setEventTitle((String) row[1]);

            // Convertir java.sql.Time a java.time.LocalTime y luego a String
            if (row[2] != null) {
                Time sqlTime = (Time) row[2];  // Asumiendo que row[2] es un java.sql.Time
                LocalTime localTime = sqlTime.toLocalTime();
                dto.setEventTime(localTime.format(timeFormatter));  // Convertir LocalTime a String
            }

            // Convertir java.sql.Date a java.time.LocalDate y luego a String
            if (row[3] != null) {
                LocalDate localDate = ((java.sql.Date) row[3]).toLocalDate();
                dto.setEventDay(localDate.format(dateFormatter));  // Convertir LocalDate a String
            }

            dto.setEventUser(((String) row[4]));
            dto.setAttachmentIds(convertToList((String) row[5]));
            dto.setAttachmentUrls(Collections.singletonList((String) row[6]));
            dto.setNotificationIds(convertToList((String) row[7]));
            dto.setNotificationTypes(Collections.singletonList((String) row[8]));
            events.add(dto);
        }
        return events;
    }


    private List<Long> convertToList(String concatenated) {
        if (concatenated != null && !concatenated.isEmpty()) {
            return Arrays.stream(concatenated.split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }




}
//hol