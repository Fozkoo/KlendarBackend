package com.example.ccalendarbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_has_attachments")
public class EventHasAttachment {
    @EmbeddedId
    private EventHasAttachmentId id;

    @MapsId("eventIdevent")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_idevent", nullable = false)
    private Event eventIdevent;

    @MapsId("attachmentsIdattachments")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attachments_idattachments", nullable = false)
    private Attachment attachmentsIdattachments;

}