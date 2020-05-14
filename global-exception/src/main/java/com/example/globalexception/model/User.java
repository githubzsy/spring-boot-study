package com.example.globalexception.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {
    public Long id;
    @NotEmpty(message = "姓名不能为空")
    public String name;
}
