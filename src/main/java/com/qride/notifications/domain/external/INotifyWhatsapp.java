package com.qride.notifications.domain.external;

public interface INotifyWhatsapp {

    void sendMessage(String message, String phoneNumber);

}
