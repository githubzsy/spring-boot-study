package com.example.mongodb;

import com.example.mongodb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void getAll(){
        mongoTemplate.findAll(User.class).forEach(System.out::println);
    }
}
