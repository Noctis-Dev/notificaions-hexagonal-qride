package com.qride.notifications.application.impl;

import com.qride.notifications.application.IEmailService;
import com.qride.notifications.application.INotificationService;
import com.qride.notifications.application.IWhatsappService;
import com.qride.notifications.domain.model.Notification;
import com.qride.notifications.domain.model.enums.NotificationChannel;
import com.qride.notifications.domain.model.enums.NotificationType;
import com.qride.notifications.domain.repository.INotificationRepository;
import com.qride.notifications.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private IEmailService emailService;

    @Autowired
    private IWhatsappService whatsappService;

    @Autowired
    private INotificationRepository repository;

    @Override
    public void sendWhatsapp(String message, String phoneNumber) {
        ThreadsUtil.runTask(() -> whatsappService.sendMessage(message, phoneNumber));

        Notification notification = new Notification();
        notification.setUuid(UUID.randomUUID());
        notification.setTo(phoneNumber);
        notification.setSendDate(LocalDate.now());
        notification.setNotificationType(NotificationType.CONFIRMATION);
        notification.setNotificationChannel(NotificationChannel.WHATSAPP);

        repository.save(notification);
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        ThreadsUtil.runTask(() -> emailService.sendEmail(to, subject, body));

        Notification notification = new Notification();
        notification.setUuid(UUID.randomUUID());
        notification.setTo(to);
        notification.setSendDate(LocalDate.now());
        notification.setNotificationType(NotificationType.CONFIRMATION);
        notification.setNotificationChannel(NotificationChannel.EMAIL);

        repository.save(notification);
    }
}
