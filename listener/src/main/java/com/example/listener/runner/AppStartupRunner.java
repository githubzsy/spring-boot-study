package com.example.listener.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner：参数被放入ApplicationArguments，通过getOptionNames()、getOptionValues()、getSourceArgs()获取参数
 */
@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        args.getOptionNames().forEach(arg -> log.info("ApplicationRunner参数:" + arg +" 值:"+ args.getOptionValues(arg)));
    }
}