package com.example.foodconnect.service;

import com.example.foodconnect.entity.Notification;
import com.example.foodconnect.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification.orElseThrow(() -> new RuntimeException("Notification not found with ID: " + id));
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification updatedNotification) {
        Notification existingNotification = getNotificationById(id);
        existingNotification.setRequestId(updatedNotification.getRequestId());
        existingNotification.setVolunteerId(updatedNotification.getVolunteerId());
        existingNotification.setSentTime(updatedNotification.getSentTime());
        existingNotification.setReadStatus(updatedNotification.getReadStatus());
        return notificationRepository.save(existingNotification);
    }

    public void deleteNotification(Long id) {
        Notification notification = getNotificationById(id);
        notificationRepository.delete(notification);
    }
}
