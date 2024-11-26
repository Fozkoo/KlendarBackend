package com.example.ccalendarbackend.Services;

import com.example.ccalendarbackend.Models.Notification;
import com.example.ccalendarbackend.Repository.EventHasNotificationRepository;
import com.example.ccalendarbackend.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EventHasNotificationRepository eventHasNotificationRepository;

//New method
    public Notification createNotification(Notification notificationDTO) {
        Notification notification = new Notification();
        notification.setId(notificationDTO.getId()!= null ? notificationDTO.getId().intValue() : null);
        notification.setType(notificationDTO.getType());
        return notificationRepository.save(notification);

    }

    @Transactional
    public void deleteNotificationById(Integer id) {
        // Elimina las referencias en la tabla intermedia
        eventHasNotificationRepository.deleteByNotificationId(id);

        // Elimina la notificación
        notificationRepository.deleteById(id);
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
