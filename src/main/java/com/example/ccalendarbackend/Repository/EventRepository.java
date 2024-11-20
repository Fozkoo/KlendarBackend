package com.example.ccalendarbackend.Repository;


import com.example.ccalendarbackend.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
            GROUP_CONCAT(DISTINCT a.idattachments) AS attachmentIds,
            GROUP_CONCAT(DISTINCT a.url) AS attachmentUrls,
            GROUP_CONCAT(DISTINCT n.idnotification) AS notificationIds,
            GROUP_CONCAT(DISTINCT n.type) AS notificationTypes
        FROM 
            event e
        LEFT JOIN event_has_attachments eha ON e.idevent = eha.event_idevent
        LEFT JOIN attachments a ON eha.attachments_idattachments = a.idattachments
        LEFT JOIN event_has_notification ehn ON e.idevent = ehn.event_idevent
        LEFT JOIN notification n ON ehn.notification_idnotification = n.idnotification
        GROUP BY 
            e.idevent, e.title, e.hora, e.day, e.iduser
        """, nativeQuery = true)
    List<Object[]> getAllEventsWithNotificationsAndAttachments();

}
