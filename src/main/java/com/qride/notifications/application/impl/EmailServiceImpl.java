package com.qride.notifications.application.impl;

import com.qride.notifications.domain.external.ISMTP;
import com.qride.notifications.application.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private ISMTP smtp;

    @Override
    public void sendEmail(String to, String subject, String body) {
        smtp.sendEmail(to, subject, body);
    }
}
