package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.dto.city.CityResponse;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.services.CityService;
import jakarta.validation.Valid;
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

    @PostMapping("addcity")
    public  ResponseEntity<CityResponse> saveCity(@Valid @RequestParam("name") String name,
                                                  @Valid @RequestParam("description") String description,
                                                  @RequestParam("images") List<MultipartFile> imageFiles) {
        List<ImageDto> images = imageFiles.stream()
                .map(file -> ImageDto.builder().file(file).build())
                .collect(Collectors.toList());
        CityAddRequest cityAddRequest = CityAddRequest.builder()
                .name(name)
                .description(description)
                .images(images)
                .build();
        return ResponseEntity.ok(cityService.saveCity(cityAddRequest));
    }
    @GetMapping("cities")
    public List<CityResponse> getAllCities() {
        return cityService.getAll();
    }
    @GetMapping("cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable String id){
        return cityService.getCityById(id);
    }
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable City cityId){
        return cityService.deleteCity(cityId);
    }


}
