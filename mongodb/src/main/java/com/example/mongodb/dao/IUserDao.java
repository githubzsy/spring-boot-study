package com.example.mongodb.dao;

import com.example.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user",path="users")
public interface IUserDao extends MongoRepository<User,String> {
    /**
     * 通过用户名查询，和JPA一样可以findBy属性自动查询
     * @param name
     * @return
     */
    User findByName(String name);
}
