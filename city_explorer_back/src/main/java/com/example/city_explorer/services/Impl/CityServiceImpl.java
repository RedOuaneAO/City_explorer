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
            City cityExist = cityRepository.findByName(cityRequest.getName());
            if(cityExist != null){
                throw new RuntimeException("This City is Already Exist");
            }
            List<Image> images = new ArrayList<>();
            for (ImageDto imageDto:cityRequest.getImages()) {
                Image image = imageService.uploadImage2(imageDto);
                images.add(image);
            }
            City city = cityMapper.dtoToCityEntity(cityRequest);
            city.setImages(images);
        return cityMapper.entityToCityResponse(cityRepository.save(city));
    }

    @Override
    public ResponseEntity<City> getCityById(String cityId) {
        City city =cityRepository.findById(Long.valueOf(cityId)).orElseThrow(()->new RuntimeException("there is no city exist with this id"));
        return ResponseEntity.ok(city);
    }

}
