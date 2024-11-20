package com.example.ccalendarbackend.Services;
import com.example.ccalendarbackend.DTO.AttachmentDTO;
import com.example.ccalendarbackend.DTO.EventResponseDTO;
import com.example.ccalendarbackend.DTO.NotificationDTO;
import com.example.ccalendarbackend.Helpers.DateTimeHelper;
import com.example.ccalendarbackend.Models.Event;
import com.example.ccalendarbackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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





    /*  Bueno basicamente se crearon dos DTO mas , para Attachment y para Notification, para
        *  poder tener una lista de attachments y de notificaciones en el EventResponseDTO y
        *  poder mostrar por separado los datos, 
        
        Para manejar la conversion del Date y el TIME se creo un helper que se llama DateTimeHelper
        que maneja la logica por separado para que quede mejor visible el codigo. pero no hace nada de otro mundo.
        (lo intente hacer con una libreria externa pero pincho)

        y el la row 5,6,7,8 se maneja la logica para agregar los attachments y las notificaciones
         a la lista de attachments y notificaciones en los DTO correspondientes.


         Y tambien cambie la consulta para que reciba el idUser  
     */

    public List<EventResponseDTO> getAllEventsByIdUser(String idUser) {
    List<Object[]> results = eventRepository.getEventsByUserId(idUser);
    List<EventResponseDTO> events = new ArrayList<>();
    Map<Long, EventResponseDTO> eventMap = new HashMap<>();

    for (Object[] row : results) {
        Long eventId = ((Number) row[0]).longValue();
        EventResponseDTO dto = eventMap.getOrDefault(eventId, new EventResponseDTO());

        dto.setEventId(eventId);
        dto.setEventTitle((String) row[1]);
        dto.setEventTime(DateTimeHelper.formatTime((Time) row[2]));
        dto.setEventDay(DateTimeHelper.formatDate((java.sql.Date) row[3]));
        dto.setEventUser((String) row[4]);

        
        if (row[5] != null && row[6] != null) {
            AttachmentDTO attachment = new AttachmentDTO();
            attachment.setId(((Number) row[5]).longValue());
            attachment.setUrl((String) row[6]);
            if (dto.getAttachments() == null) {
                dto.setAttachments(new ArrayList<>());
            }
            dto.getAttachments().add(attachment);
        }

        
        if (row[7] != null && row[8] != null) {
            NotificationDTO notification = new NotificationDTO();
            notification.setId(((Number) row[7]).longValue());
            notification.setType((String) row[8]);
            if (dto.getNotifications() == null) {
                dto.setNotifications(new ArrayList<>());
            }
            dto.getNotifications().add(notification);
        }

        eventMap.put(eventId, dto);
    }

    events.addAll(eventMap.values());
    return events;
}





}


