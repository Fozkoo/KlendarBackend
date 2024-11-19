package com.example.ccalendarbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_has_notification")
public class EventHasNotification {
    @EmbeddedId
    private EventHasNotificationId id;

    @MapsId("eventIdevent")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_idevent", nullable = false)
    private Event eventIdevent;

    @MapsId("notificationIdnotification")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notification_idnotification", nullable = false)
    private Notification notificationIdnotification;

}