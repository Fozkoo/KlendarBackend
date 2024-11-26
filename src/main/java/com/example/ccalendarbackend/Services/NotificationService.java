package com.example.ccalendarbackend.Services;

import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Method to update notifications

    public Notification modifyNotificationById(Integer id, Notification NotificationDTO) {
        Optional<Notification> existingNotification = notificationRepository.findById(id);
        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            notification.setType(NotificationDTO.getType());
            return notificationRepository.save(notification);
        }
        return null;
    }



}
