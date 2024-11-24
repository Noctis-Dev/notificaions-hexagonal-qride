package com.qride.notifications.application;

public interface IEmailService {
    void sendEmail(String to, String subject, String body);
}
