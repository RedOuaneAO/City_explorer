package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("Cities")
    public List<City> getAll() {
        return cityService.getAll();
    }
    @PostMapping("City")
    public String save(@RequestBody City city) {
        return cityService.save(city);
    }
    @PutMapping("cityUpdate")
    public String updateCity(@RequestBody City city) {
        return cityService.update(city);
    }
    @DeleteMapping("DeleteCity")
    public String deleteCity(@RequestBody City city) {
        return cityService.deleteCity(city);
    }

}
