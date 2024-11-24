package com.qride.notifications.domain.repository;

import com.qride.notifications.domain.model.Notification;

public interface INotificationRepository {

    Notification save(Notification notification);

}
