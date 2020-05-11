package com.example.mongodb.controller;

import com.example.mongodb.entity.User;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Resource
    private MongoTemplate mongoTemplate;

    @GetMapping("/user")
    public List<User> getAll() {
        return mongoTemplate.findAll(User.class, "user");
    }

    @PostMapping("/user")
    public User add(@RequestBody User user) {
        return mongoTemplate.insert(user, "user");
    }

    @DeleteMapping("/user/{id}")
    public DeleteResult delete(@PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.remove(query, User.class, "user");
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable String id){
        Query query=new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,User.class);
    }
}