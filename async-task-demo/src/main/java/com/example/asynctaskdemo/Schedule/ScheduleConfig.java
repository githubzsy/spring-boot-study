package com.example.asynctaskdemo.Schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @EnableScheduling 在任意一个配置类上标注即可
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
 
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(scheduledTaskExecutor());
    }

    /**
     * 新建了一个定时任务线程池，池子大小为3
     * @return
     */
    @Bean
    public Executor scheduledTaskExecutor() {
        return Executors.newScheduledThreadPool(3); //指定线程池大小
    }
}