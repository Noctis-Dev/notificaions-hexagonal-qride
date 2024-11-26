package com.qride.notifications.infraestructure.mapper.impl;

import com.qride.notifications.domain.model.Notification;
import com.qride.notifications.domain.model.enums.NotificationChannel;
import com.qride.notifications.domain.model.enums.NotificationType;
import com.qride.notifications.infraestructure.entities.NotificationEntity;
import com.qride.notifications.infraestructure.entities.enums.NotificationChannelEntity;
import com.qride.notifications.infraestructure.entities.enums.NotificationTypeEntity;
import com.qride.notifications.infraestructure.mapper.INotificationMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapperImpl implements INotificationMapper {
    @Override
    public Notification toDomain(NotificationEntity entity) {
        Notification notification = new Notification();

        notification.setId(entity.getId());
        notification.setUuid(entity.getNotificationUuid());
        notification.setTo(entity.getTo());
        notification.setSendDate(entity.getSendDate());
        notification.setCreatedAt(entity.getCreatedAt());
        notification.setTittle(entity.getTittle());
        notification.setMessage(entity.getMessage());
        notification.setNotificationChannel(NotificationChannel.valueOf(entity.getNotificationChannel().name()));
        notification.setNotificationType(NotificationType.valueOf(entity.getNotificationType().name()));

        return notification;
    }

    @Override
    public NotificationEntity toEntity(Notification domain) {
        NotificationEntity notificationEntity = new NotificationEntity();

        notificationEntity.setId(domain.getId());
        notificationEntity.setNotificationUuid(domain.getUuid());
        notificationEntity.setTo(domain.getTo());
        notificationEntity.setSendDate(domain.getSendDate());
        notificationEntity.setCreatedAt(domain.getCreatedAt());
        notificationEntity.setTittle(domain.getTittle());
        notificationEntity.setMessage(domain.getMessage());
        notificationEntity.setNotificationChannel(NotificationChannelEntity.valueOf(domain.getNotificationChannel().name()));
        notificationEntity.setNotificationType(NotificationTypeEntity.valueOf(domain.getNotificationType().name()));

        return notificationEntity;
    }
}
