package com.example.mq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;


@EnableJms //开启消息中间件的服务能力
@Configuration
public class ActiveMQConfig {

    /**配置一个消息队列（P2P模式）
     * @return p2p队列
     * */
    @Bean
    public Queue messageQueue() {
        //这里相当于为消息队列起一个名字用于生产消费用户访问日志
        return new ActiveMQQueue("message.queue");
    }

    /**
     * 配置一个消息队列（发布订阅模式）
     * @return 发布订阅的队列
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("message.topic");
    }
}