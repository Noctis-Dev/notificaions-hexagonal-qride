package com.qride.notifications.domain.external;

public interface ISMTP {

    void sendEmail(String to, String subject, String body);

}
