package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.EventHasNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EventHasNotificationRepository extends JpaRepository<EventHasNotification, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EventHasNotification ehn WHERE ehn.eventIdevent.id = :eventId")
    void deleteByEventId(@Param("eventId") Integer eventId);




    @Modifying
    @Query("UPDATE EventHasNotification eh SET eh.notificationIdnotification = :notificationId WHERE eh.eventIdevent = :eventId")
    void updateNotification(@Param("eventId") int eventId, @Param("notificationId") int notificationId);


    @Modifying
    @Transactional
    @Query("UPDATE EventHasNotification ehn SET ehn.notificationIdnotification.id = :notificationId WHERE ehn.eventIdevent.id = :eventId")
    void updateEventNotification(@Param("notificationId") Integer notificationId,
                                 @Param("eventId") Integer eventId);


}
