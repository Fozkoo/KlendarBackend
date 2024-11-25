package com.example.ccalendarbackend.Services;

import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
//New method
    public Notification createNotification(Notification notificationDTO) {
        Notification notification = new Notification();
        notification.setId(notificationDTO.getId()!= null ? notificationDTO.getId().intValue() : null);
        notification.setType(notificationDTO.getType());
        return notificationRepository.save(notification);

    }




}
