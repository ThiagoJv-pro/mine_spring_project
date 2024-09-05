package com.mining.infrastructure.configuration.events.jmsConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;

@Service
public class JmsProducer {
    
    @Autowired
    private JmsConfig jmsConfig;

    public void sendMessage(String destination, String message) throws JMSException{
        jmsConfig.jmsTemplate().convertAndSend(destination, message);
    }
}
