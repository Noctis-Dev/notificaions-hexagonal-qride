package com.qride.notifications.infraestructure.listeners;

import com.qride.notifications.application.INotificationService;
import com.qride.notifications.domain.events.NotificationEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    @Autowired
    private INotificationService service;

    @RabbitListener(queues = "NotificationEvent")
    public void handleNotificationEvent(NotificationEvent event) {
        switch (event.getType()) {
            case EMAIL -> service.sendEmail(event.getDestination(), event.getSubject(), event.getMessage());
            case WHATSAPP -> service.sendWhatsapp(event.getMessage(), event.getDestination());
            default -> throw new RuntimeException("Invalid channel");
        }
    }

}
