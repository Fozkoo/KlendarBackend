package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.iduser = :userId")
    List<Event> findEventsByUserId(String userId);

    @Query(value = """
        SELECT
            e.idevent AS eventId,
            e.title AS eventTitle,
            e.hora AS eventTime,
            e.day AS eventDay,
            e.iduser AS eventUser,
            a.idattachments AS attachmentId,
            a.url AS attachmentUrl,
            n.idnotification AS notificationId,
            n.type AS notificationType
        FROM
            event e
        LEFT JOIN event_has_attachments eha ON e.idevent = eha.event_idevent
        LEFT JOIN attachments a ON eha.attachments_idattachments = a.idattachments
        LEFT JOIN event_has_notification ehn ON e.idevent = ehn.event_idevent
        LEFT JOIN notification n ON ehn.notification_idnotification = n.idnotification
        WHERE
            e.iduser = :userId  -- Se espera un parámetro String
        ORDER BY 
            e.idevent
    """, nativeQuery = true)
    List<Object[]> getEventsByUserId(@Param("userId") String userId);
    

}
