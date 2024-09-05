package com.mining.infrastructure.configuration.events.jmsConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;

@Service
public class JmsReceiver {
    
    @Autowired
    private JmsConfig jmsConfig;

    @JmsListener(destination="queue")
    public void receiverMessage(String destinationName) throws JMSException {
        jmsConfig.jmsTemplate().receive(destinationName);
    }
}
