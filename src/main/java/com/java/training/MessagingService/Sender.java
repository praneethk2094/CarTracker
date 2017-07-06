package com.java.training.MessagingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by prane on 7/6/2017.
 */
@Service
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${spring.jms.template.default-destination}")
    private String destination;

    public String messageSender(String Message) {
        jmsTemplate.convertAndSend(destination, Message);
        return Message;
    }
}
