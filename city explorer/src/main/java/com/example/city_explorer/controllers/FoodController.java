package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class FoodController {
//    private final FoodService foodService ;
//
//
//    @GetMapping("foods")
//    public List<Food> getAll() {
//        return foodService.getAll();
//    }
//    @PostMapping("food")
//    public String save(@RequestBody Food food) {
//        return foodService.save(food);
//    }
//    @PutMapping("foodUpdate")
//    public String updateCity(@RequestBody Food food) {
//        return foodService.update(food);
//    }
//    @DeleteMapping("DeleteFood")
//    public String deleteCity(@RequestBody Food food) {
//        return foodService.deleteCity(food);
//    }
}
