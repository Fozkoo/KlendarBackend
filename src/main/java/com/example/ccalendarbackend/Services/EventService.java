package com.example.ccalendarbackend.Services;


import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        for (Object[] row : results) {
            EventResponseDTO dto = new EventResponseDTO();
            dto.setEventId(((Number) row[0]).longValue());
            dto.setEventTitle((String) row[1]);
            dto.setEventTime((String) row[2]);
            dto.setEventDay((String) row[3]);
            dto.setEventUser(((Number) row[4]).longValue());
            dto.setAttachmentIds(convertToList((String) row[5]));
            dto.setAttachmentUrls(convertToList((String) row[6]));
            dto.setNotificationIds(convertToList((String) row[7]));
            dto.setNotificationTypes(convertToList((String) row[8]));
            events.add(dto);
        }
        return events;
    }

    private List<Long> convertToList(String concatenated) {
        return concatenated != null ? Arrays.asList(concatenated.split(",")) : new ArrayList<>();
    }


}
//hola