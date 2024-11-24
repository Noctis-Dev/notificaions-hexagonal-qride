package com.qride.notifications.infraestructure.repository.jpa;

import com.qride.notifications.infraestructure.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationEntityRepository extends JpaRepository<NotificationEntity, Long> {
  }