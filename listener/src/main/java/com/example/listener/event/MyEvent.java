package com.example.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}