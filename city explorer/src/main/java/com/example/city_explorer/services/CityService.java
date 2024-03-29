package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.dto.city.CityAddRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
    String save(CityAddRequest city);
    City findById(Long id);

    List<City> getAll();

    ResponseEntity<String> deleteCity(City cityId);
}
