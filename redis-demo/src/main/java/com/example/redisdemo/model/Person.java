package com.example.redisdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@RedisHash("person")
public class Person implements Serializable {
  /**
   * 无参构造函数不可省略，因为后面jackson2json序列化会调用该类的无参构造函数
   */
  Person(){

  }

  private static final long serialVersionUID = -8985545025228238754L;

  @Id
  String id;
  String firstname;
  String lastname;
  Address address;

  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }
}