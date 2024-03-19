package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    @PostMapping("city")
    public String save(@RequestBody CityAddRequest city) {
        return cityService.save(city);
    }
    @GetMapping("cities")
    public List<City> getAllCities() {
        return cityService.getAll();
    }
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable City cityId){
        return cityService.deleteCity(cityId);
    }

}
