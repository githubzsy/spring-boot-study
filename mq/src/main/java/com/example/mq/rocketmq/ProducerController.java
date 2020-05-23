package com.example.mq.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProducerController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/rmqSend")
    public String send(String msg) {
        rocketMQTemplate.convertAndSend(RocketConstants.TEST_TOPIC,msg);
        return "success";
    }
}