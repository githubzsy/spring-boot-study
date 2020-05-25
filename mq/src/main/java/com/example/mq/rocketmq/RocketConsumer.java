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
public class RocketConsumer implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {
    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        // 如果是同一组consumerGroup有多个consumer，那么必须将instanceName设置为不同值，不然程序起不来
        // 因为不设置默认都会设置为同一个instanceName，这样是rocketMQ不允许的
        consumer.setInstanceName("consumer");
    }

    @Override
    public void onMessage(String message) {
        System.err.println("RocketConsumer接收到消息：" + message);
    }
}