package com.example.listener.controller;

import com.example.listener.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HelloController {

    @Resource
    ConfigurableApplicationContext applicationContext;

    @GetMapping("/index")
    public String index(){
        log.info("HelloController index方法");
        return "hello world";
    }

    @GetMapping("/publish")
    public String publish(){
        //TODO 业务处理
        log.info("HelloController publish方法");
        applicationContext.publishEvent(new MyEvent("假设需要发邮件了"));
        return "发布成功";
    }
}
