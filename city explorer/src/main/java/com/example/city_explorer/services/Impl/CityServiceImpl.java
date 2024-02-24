package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.repositories.CityRepository;
import com.example.city_explorer.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public String save(City city) {
        cityRepository.save(city);
        return "successful";
    }

    @Override
    public String update(City city) {
        cityRepository.save(city);
        return "successful";
    }

    @Override
    public String deleteCity(City city) {
        cityRepository.delete(city);
        return "successful";
    }
}
