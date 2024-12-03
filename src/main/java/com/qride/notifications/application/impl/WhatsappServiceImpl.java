package com.qride.notifications.application.impl;

import com.qride.notifications.application.IWhatsappService;
import com.qride.notifications.domain.external.IMetaNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsappServiceImpl implements IWhatsappService {

    @Autowired
    private IMetaNotify notify;

    @Override
    public void sendMessage(String message, String phoneNumber) {
        notify.sendMessage(message, phoneNumber);
    }
}
