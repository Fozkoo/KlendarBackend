package com.example.ccalendarbackend.Services;
import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.Helpers.ConvertListHelper;
import com.example.ccalendarbackend.Helpers.DateTimeHelper;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public ResponseEntity<?> getAllEventsById(@PathVariable String idUser) {
        return  ResponseEntity.ok(eventRepository.findEventsByUserId(idUser));
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
            dto.setEventTime(DateTimeHelper.formatTime((Time) row[2]));
            dto.setEventDay(DateTimeHelper.formatDate((java.sql.Date) row[3]));
            dto.setEventUser((String) row[4]);
            dto.setAttachmentIds(ConvertListHelper.convertToLongList((String) row[5]));
            dto.setAttachmentUrls(ConvertListHelper.splitToStringList((String) row[6]));
            dto.setNotificationIds(ConvertListHelper.convertToLongList((String) row[7]));
            dto.setNotificationTypes(ConvertListHelper.splitToStringList((String) row[8]));
            events.add(dto);
        }

        return events;
    }

}


