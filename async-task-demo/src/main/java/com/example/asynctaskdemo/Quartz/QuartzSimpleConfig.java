package com.example.asynctaskdemo.Quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzSimpleConfig {
//    //指定具体的定时任务类
//    @Bean
//    public JobDetail uploadTaskDetail() {
//        return JobBuilder.newJob(QuartzSimpleTask.class).withIdentity("QuartzSimpleTask").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger uploadTaskTrigger() {
//        //这里设定触发执行的方式
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
//        // 指定job方法为uploadTaskDetail()
//        // 指定标识为QuartzSimpleTask
//        // 指定调度计划为scheduleBuilder
//        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
//                .withIdentity("QuartzSimpleTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
}