package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.dto.food.FoodAddRequest;

import java.util.List;

public interface FoodService {

    String save(FoodAddRequest food);

    List<Food> findAll(List<Long> foodIds);

    List<Food> getFoodByCity(Long cityId);

    List<Food> getAllFood();
}
