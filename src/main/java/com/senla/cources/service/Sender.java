package com.senla.cources.service;

import com.senla.cources.dto.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

//    @Scheduled(fixedDelay = 10000)
//    public void sendMessage() {
//        jmsTemplate.convertAndSend("springbootQueue", "message: now is " + LocalDateTime.now());
//    }

    @Scheduled(fixedDelay = 20000)
    public void sendEmail() {
        Email email = new Email();
        email.setTo("me");
        email.setBody(LocalDateTime.now().toString());
        jmsTemplate.convertAndSend("springbootQueue", email);
    }

}
