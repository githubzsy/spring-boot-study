package com.example.redisdemo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

  Address(){

  }

  private static final long serialVersionUID = -8985545025228238771L;

  String city;
  String country;

  public Address(String city, String country) {
    this.city = city;
    this.country = country;
  }
}