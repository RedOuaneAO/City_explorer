package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.dto.food.FoodAddRequest;
import com.example.city_explorer.repositories.FoodRepository;
import com.example.city_explorer.services.CityService;
import com.example.city_explorer.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final CityService cityService;
    @Override
    public String save(FoodAddRequest food) {
        City city =cityService.findById(food.getCityId());
        Food existFood= foodRepository.findByName(food.getName());
        if(existFood != null){
            return "this food is  Already exist";
        }
        Food food1 = Food.builder()
                .name(food.getName())
                .description(food.getDescription())
                .city(city)
                .build();
         foodRepository.save(food1);
         return "success";
    }

    @Override
    public List<Food> findAll(List<Long> foodIds) {
        return foodIds.stream().map(aLong -> findById(aLong)).toList();
    }

    public Food findById(Long id){
        return foodRepository.findById(id).orElseThrow(()->new RuntimeException("there is know food with this is "+ id));
    }

}
