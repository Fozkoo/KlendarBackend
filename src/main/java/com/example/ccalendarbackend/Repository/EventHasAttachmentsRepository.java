package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.EventHasAttachment;
import com.example.ccalendarbackend.Models.EventHasNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EventHasAttachmentsRepository extends JpaRepository<EventHasAttachment, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM EventHasNotification ehn WHERE ehn.eventIdevent.id = :eventId")
    void deleteByEventId(@Param("eventId") Integer eventId);


    @Modifying
    @Query("UPDATE EventHasAttachment e SET e.url = :url WHERE e.id = :id")
    void updateUrl(@Param("id") int id, @Param("url") String url);


}
