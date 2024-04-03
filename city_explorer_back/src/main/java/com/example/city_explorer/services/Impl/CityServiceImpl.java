package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.dto.city.CityResponse;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.mappers.CityMapper;
import com.example.city_explorer.repositories.CityRepository;
import com.example.city_explorer.services.CityService;
import com.example.city_explorer.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final ImageService imageService;
    @Override
    public String save(CityAddRequest city) {
        City existCity= cityRepository.findByName(city.getName());
        if(existCity != null){
            return "city Already exist";
        }
        City city1 = cityMapper.dtoToCityEntity(city);
        cityRepository.save(city1);
        return "success";
    }
    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(()->new RuntimeException("this city doesn't exist"));
    }

    @Override
    public List<CityResponse> getAll() {
        return cityRepository.findAll().stream().map(city -> cityMapper.entityToCityResponse(city)).toList();
    }

    @Override
    public ResponseEntity<String> deleteCity(City cityId) {
        return null;
    }

    @Override
    public CityResponse saveCity(CityAddRequest cityRequest) {
            List<Image> images = new ArrayList<>();
            for (ImageDto imageDto:cityRequest.getImages()) {
                Image image = imageService.uploadImage2(imageDto);
                images.add(image);
            }
            City city1 = cityMapper.dtoToCityEntity(cityRequest);
            city1.setImages(images);
        return cityMapper.entityToCityResponse(cityRepository.save(city1));
    }

    @Override
    public ResponseEntity<City> getCityById(String cityId) {
        City city =cityRepository.findById(Long.valueOf(cityId)).orElseThrow(()->new RuntimeException("there is no city exist with this id"));
        return ResponseEntity.ok(city);
    }

}
