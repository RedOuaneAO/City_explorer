package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.dto.city.CityResponse;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<CityResponse> getAllCities() {
        return cityService.getAll();
    }
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable City cityId){
        return cityService.deleteCity(cityId);
    }

    @PostMapping("addcity")
    public  ResponseEntity<CityResponse> saveCity(@RequestParam("name") String name,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("images") List<MultipartFile> imageFiles) {
        // Convert MultipartFile to ImageDto objects
        List<ImageDto> images = imageFiles.stream()
                .map(file -> ImageDto.builder().file(file).build())
                .collect(Collectors.toList());
        // create  CityAddRequest object
        CityAddRequest cityAddRequest = CityAddRequest.builder()
                .name(name)
                .description(description)
                .images(images)
                .build();
        return ResponseEntity.ok(cityService.saveCity(cityAddRequest));
    }
}
