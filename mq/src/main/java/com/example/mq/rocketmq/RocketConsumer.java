package com.example.mq.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * consumerGroup=消费者组的名称
 */
@Service
@RocketMQMessageListener(consumerGroup = RocketConstants.CONSUMER_GROUP1, topic = RocketConstants.TEST_TOPIC)
public class RocketConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.err.println("RocketConsumer接收到消息：" + message);
    }
}