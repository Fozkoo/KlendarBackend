package com.example.ccalendarbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventResponseDTO {
    private Long eventId;
    private String eventTitle;
    private String eventTime;
    private String eventDay;
    private Long eventUser;
    private List<Long> attachmentIds;
    private List<String> attachmentUrls;
    private List<Long> notificationIds;
    private List<String> notificationTypes;


    public EventResponseDTO(Long eventId, String eventTitle, String eventTime, String eventDay, Long eventUser, List<Long> attachmentIds, List<String> attachmentUrls, List<Long> notificationIds, List<String> notificationTypes) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.eventDay = eventDay;
        this.eventUser = eventUser;
        this.attachmentIds = attachmentIds;
        this.attachmentUrls = attachmentUrls;
        this.notificationIds = notificationIds;
        this.notificationTypes = notificationTypes;
    }


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Long getEventUser() {
        return eventUser;
    }

    public void setEventUser(Long eventUser) {
        this.eventUser = eventUser;
    }

    public String getEventDay() {
        return eventDay;
    }

    public void setEventDay(String eventDay) {
        this.eventDay = eventDay;
    }

    public List<Long> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<Long> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
    }

    public List<String> getNotificationTypes() {
        return notificationTypes;
    }

    public void setNotificationTypes(List<String> notificationTypes) {
        this.notificationTypes = notificationTypes;
    }

    public List<Long> getNotificationIds() {
        return notificationIds;
    }

    public void setNotificationIds(List<Long> notificationIds) {
        this.notificationIds = notificationIds;
    }
}
