package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.EventHasNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EventHasNotificationRepository extends JpaRepository<EventHasNotification, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EventHasNotification ehn WHERE ehn.eventIdevent.id = :eventId")
    void deleteByEventId(@Param("eventId") Integer eventId);
}
