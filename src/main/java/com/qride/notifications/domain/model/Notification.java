package com.qride.notifications.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;
import com.qride.notifications.domain.model.enums.NotificationChannel;
import com.qride.notifications.domain.model.enums.NotificationType;

import java.time.LocalDate;

@Getter @Setter
public class Notification {
    private Long id;

    @UUID
    private java.util.UUID uuid;

    @NotNull
    private LocalDate sendDate;

    @NotNull
    private String to;

    @NotNull
    private String tittle;

    @NotNull
    private String message;

    @NotNull
    private LocalDate createdAt;

    @NotNull
    private NotificationChannel notificationChannel;

    @NotNull
    private NotificationType notificationType;

}
