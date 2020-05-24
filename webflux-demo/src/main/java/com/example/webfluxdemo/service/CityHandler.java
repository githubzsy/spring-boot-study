package com.example.webfluxdemo.service;

import com.example.webfluxdemo.dao.CityRepository;
import com.example.webfluxdemo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CityHandler {

    private final CityRepository cityRepository;

    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * 返回一个或0个对象
     * @param city
     * @return
     */
    public Mono<City> save(City city) {
        return cityRepository.insert(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Flux<City> findAllCity() {
        return cityRepository.findAll();
    }

    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

    public Mono<Void> deleteCity(Long id) {
        return cityRepository.deleteById(id);
    }
}