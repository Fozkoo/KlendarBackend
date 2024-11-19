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
public class EventHasAttachmentId implements java.io.Serializable {
    private static final long serialVersionUID = -8746601656495822673L;
    @Column(name = "event_idevent", nullable = false)
    private Integer eventIdevent;

    @Column(name = "attachments_idattachments", nullable = false)
    private Integer attachmentsIdattachments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventHasAttachmentId entity = (EventHasAttachmentId) o;
        return Objects.equals(this.attachmentsIdattachments, entity.attachmentsIdattachments) &&
                Objects.equals(this.eventIdevent, entity.eventIdevent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachmentsIdattachments, eventIdevent);
    }

}