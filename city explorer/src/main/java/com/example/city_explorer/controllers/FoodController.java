package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.dto.food.FoodAddRequest;
import com.example.city_explorer.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService ;
    @PostMapping("food")
    public String save(@RequestBody FoodAddRequest food) {
        return foodService.save(food);
    }

}
