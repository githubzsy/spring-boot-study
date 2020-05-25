package com.example.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * consumerGroup=消费者组的名称
 */
@Service
@RocketMQMessageListener(consumerGroup = RocketConstants.CONSUMER_GROUP1, topic = RocketConstants.TEST_TOPIC)
public class RocketConsumer2 implements RocketMQListener<String> , RocketMQPushConsumerLifecycleListener {
    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setInstanceName("consumer2");
    }

    @Override
    public void onMessage(String message) {
        System.err.println("RocketConsumer2接收到消息：" + message);
    }
}