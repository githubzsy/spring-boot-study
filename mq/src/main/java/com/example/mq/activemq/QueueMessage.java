package com.example.mq.activemq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class QueueMessage implements Serializable {

    private String title;

    private String content;

}