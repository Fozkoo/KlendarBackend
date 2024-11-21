package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
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

        /*     !!!!       */

    @Modifying
    @Query(value = "INSERT INTO event (title, hora, day, iduser) VALUES (:title, :hora, :day, :iduser)", nativeQuery = true)
    @Transactional
    int insertEvent(@Param("title") String title, @Param("hora") LocalTime hora, @Param("day") LocalDate day, @Param("iduser") String iduser);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    int getLastInsertedEventId();

    @Modifying
    @Query(value = "INSERT INTO attachments (url) VALUES (:url)", nativeQuery = true)
    @Transactional
    int insertAttachment(@Param("url") String url);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    int getLastInsertedAttachmentId();

    @Modifying
    @Query(value = "INSERT INTO event_has_attachments (event_idevent, attachments_idattachments) VALUES (:eventId, :attachmentId)", nativeQuery = true)
    @Transactional
    void insertEventAttachmentLink(@Param("eventId") int eventId, @Param("attachmentId") int attachmentId);

    @Modifying
    @Query(value = "INSERT INTO event_has_notification (event_idevent, notification_idnotification) VALUES (:eventId, :notificationId)", nativeQuery = true)
    @Transactional
    void insertEventNotificationLink(@Param("eventId") int eventId, @Param("notificationId") int notificationId);



}
