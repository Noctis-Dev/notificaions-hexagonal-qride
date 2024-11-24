package com.qride.notifications.application;

public interface INotificationService {
    void sendWhatsapp(String message, String phoneNumber);
    void sendEmail(String to, String subject, String body);
}
