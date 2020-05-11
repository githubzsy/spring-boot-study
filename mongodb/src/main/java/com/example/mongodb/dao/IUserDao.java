package com.example.mongodb.dao;

import com.example.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserDao extends MongoRepository<User,String> {
    /**
     * 通过用户名查询，和JPA一样可以findBy属性自动查询
     * @param name
     * @return
     */
    User findByName(String name);
}
