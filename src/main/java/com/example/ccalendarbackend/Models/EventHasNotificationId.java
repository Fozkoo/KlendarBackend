package com.example.ccalendarbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EventHasNotificationId implements java.io.Serializable {
    private static final long serialVersionUID = 1276312051436573340L;
    @Column(name = "event_idevent", nullable = false)
    private Integer eventIdevent;

    @Column(name = "notification_idnotification", nullable = false)
    private Integer notificationIdnotification;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventHasNotificationId entity = (EventHasNotificationId) o;
        return Objects.equals(this.eventIdevent, entity.eventIdevent) &&
                Objects.equals(this.notificationIdnotification, entity.notificationIdnotification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventIdevent, notificationIdnotification);
    }

}