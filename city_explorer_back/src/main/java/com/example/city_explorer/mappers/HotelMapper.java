package com.example.city_explorer.mappers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.dto.hotel.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")

public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
    @Mapping(source = "cityId", target = "city" , qualifiedByName ="mapCity")
    Hotel dtoToHotelEntity(HotelAddRequest hotelAddRequest);

    @Mapping(target = "images", source = "images" , qualifiedByName ="mapImages")
    @Mapping(source = "city.id", target = "cityId")
    HotelResponse entityToHotelResponse(Hotel hotel);
    @Named("mapImages")
    default List<String> map(List<Image> images) {
        return images.stream()
                .map(image -> image.getImageUrl())
                .collect(Collectors.toList());
    }

    @Named("mapCity")
    default City mapCity(Long cityId) {
        return City.builder().id(cityId).build();
    }
}
