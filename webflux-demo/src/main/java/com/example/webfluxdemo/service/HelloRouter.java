package com.example.webfluxdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HelloRouter {
    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler helloHandler) {
        // 希望得到一个get请求
        // 可以接收的参数是普通文本
        // 用halloHandler的helloCity去响应
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        helloHandler::helloCity);
    }
}