package com.example.mq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
    @JmsListener(destination = "message.topic")
    public void receiver1(QueueMessage queueMessage) {
        System.out.println("TopicConsumer : receiver1 : " + queueMessage);
    }

    @JmsListener(destination = "message.topic")
    public void receiver2(QueueMessage queueMessage) {
        System.out.println("TopicConsumer : receiver2 : " + queueMessage);
    }

    @JmsListener(destination = "message.topic")
    public void receiver3(QueueMessage queueMessage) {
        System.out.println("TopicConsumer : receiver3 : " + queueMessage);
    }
}