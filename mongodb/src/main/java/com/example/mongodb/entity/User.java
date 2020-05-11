package com.example.mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class User {

    private String id;
    private String name;
    private Integer age;

}