package com.qride.notifications.infraestructure.repository;

import com.qride.notifications.domain.model.Notification;
import com.qride.notifications.domain.repository.INotificationRepository;
import com.qride.notifications.infraestructure.mapper.INotificationMapper;
import com.qride.notifications.infraestructure.repository.jpa.NotificationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationRepositoryImpl implements INotificationRepository {

    @Autowired
    private NotificationEntityRepository repository;

    @Autowired
    private INotificationMapper mapper;

    @Override
    public Notification save(Notification notification) {
        return mapper.toDomain(repository.save(mapper.toEntity(notification)));
    }
}
