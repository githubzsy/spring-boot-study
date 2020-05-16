package com.example.asynctaskdemo.Schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobs {

//    /**
//     * 表示方法执行完成后5秒再开始重复执行
//     * @throws InterruptedException
//     */
//    @Scheduled(fixedDelay=5000)
//    public void fixedDelayJob() throws InterruptedException{
//        System.out.println("fixedDelay 开始:" + new Date() + Thread.currentThread());
//        Thread.sleep(10 * 1000);
//        System.out.println("fixedDelay 结束:" + new Date() + Thread.currentThread());
//    }
//
//    /**
//     * fixedRate 是有一个时刻表的概念，在任务启动时，T1、T2、T3就已经排好了执行的时刻，比如1分、2分、3分，当T1的执行时间大于1分钟时，就会造成T2晚点，当T1执行完时T2立即执行
//     * 每隔三秒一次
//     * @throws InterruptedException
//     */
//    @Scheduled(fixedRate=3000)
//    public void fixedRateJob()throws InterruptedException{
//        System.out.println("===========fixedRate 开始:" + new Date() + Thread.currentThread());
//        Thread.sleep(5 * 1000);
//        System.out.println("===========fixedRate 结束:" + new Date() + Thread.currentThread());
//    }
//
//    /**
//     * cron表达式可以定制化执行任务，但是执行的方式是与fixedDelay相近的，也是会按照上一次方法结束时间开始算起
//     * 结束后10秒开始重复执行
//     */
//    @Scheduled(cron="0/10 * * * * ? ")
//    public void cronJob(){
//        System.out.println("=========================== ...>>cron...." + new Date() + Thread.currentThread());
//    }
}