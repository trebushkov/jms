package com.senla.cources.service;

import com.senla.cources.dto.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    private Logger log = LoggerFactory.getLogger(Consumer2.class);

    @JmsListener(destination = "${myqueue}")
    public void onMessage(final Message<Email> message) {
        MessageHeaders headers =  message.getHeaders();
        log.info("Consumer 2 : headers received : {}", headers);

        Email response = message.getPayload();
        log.info("Consumer 2 : response received : {}",response);
    }

}
