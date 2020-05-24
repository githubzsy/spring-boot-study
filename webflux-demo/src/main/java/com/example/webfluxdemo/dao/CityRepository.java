package com.example.webfluxdemo.dao;

import com.example.webfluxdemo.model.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 模拟实现的dao层
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
    Flux<City> findByCityName(String cityName);
}