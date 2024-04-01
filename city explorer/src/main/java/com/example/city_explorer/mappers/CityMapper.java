package com.example.city_explorer.mappers;

import com.example.city_explorer.demain.models.City;
//import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.city.CityAddRequest;
//import com.example.city_explorer.dto.city.CityResponse;
import com.example.city_explorer.dto.city.CityResponse;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City dtoToCityEntity(CityAddRequest cityAddRequest);

    @Mapping(target = "images", source = "images" , qualifiedByName ="mapImages")
    CityResponse entityToCityResponse(City city);
    @Named("mapImages")
    default List<String> map(List<Image> images) {
        return images.stream()
                .map(image -> image.getImageUrl())
                .collect(Collectors.toList());
    }
}
