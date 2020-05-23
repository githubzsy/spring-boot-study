package com.example.mq.activemq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Topic;

@RestController
public class TopicProducerController {
    
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic messageTopic;

    @RequestMapping("/sendTopic")
    public QueueMessage send(){
        QueueMessage queueMessage = new QueueMessage("测试","测试内容");
        jmsMessagingTemplate.convertAndSend(messageTopic, queueMessage);
        return queueMessage;
    }
}