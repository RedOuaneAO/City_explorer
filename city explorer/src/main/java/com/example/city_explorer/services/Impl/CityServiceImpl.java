package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.repositories.CityRepository;
import com.example.city_explorer.services.CityService;
import com.example.city_explorer.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
//    private final FoodService foodService;
    @Override
    public String save(CityAddRequest city) {
//        List<Food> foodList = foodService.findAll(city.getFoodList());
        City existCity= cityRepository.findByName(city.getName());
        if(existCity != null){
            return "city Already exist";
        }
        City city1 = City.builder()
                .name(city.getName())
                .description(city.getDescription())
                .build();
        cityRepository.save(city1);
        return "success";
    }
    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(()->new RuntimeException("this city doesn't exist"));
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteCity(City cityId) {
        return null;
    }

}
