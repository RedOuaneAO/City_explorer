package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.dto.hotel.HotelResponse;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.mappers.HotelMapper;
import com.example.city_explorer.repositories.HotelRepository;
import com.example.city_explorer.services.CityService;
import com.example.city_explorer.services.HotelService;
import com.example.city_explorer.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final CityService cityService;
    private  final ImageService imageService;
    private final HotelMapper hotelMapper;
    @Override
    public String save(HotelAddRequest hotelDetails) {
        City city =cityService.findById(hotelDetails.getCityId());
        Hotel existHotel= hotelRepository.findByName(hotelDetails.getName());
        if(existHotel != null){
            return "this hotel is  Already exist";
        }
        Hotel hotel = Hotel.builder()
                .name(hotelDetails.getName())
                .description(hotelDetails.getDescription())
                .build();
        hotelRepository.save(hotel);
        return "success";
    }

    @Override
    public String update(Hotel hotel) {
        hotelRepository.save(hotel);
        return "success";
    }

    @Override
    public List<HotelResponse> getAll() {
        return hotelRepository.findAll().stream().map(hotel -> hotelMapper.entityToHotelResponse(hotel)).toList();
    }

    @Override
    public String deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
        return "success";
    }

    @Override
    public HotelResponse saveHotel(HotelAddRequest hotelAddRequest) {
        Hotel hotelExist = hotelRepository.findByName(hotelAddRequest.getName());
        if(hotelExist != null){
            throw new RuntimeException("This Hotel is Already Exist");
        }
        List<Image> images = new ArrayList<>();
        for (ImageDto imageDto:hotelAddRequest.getImages()) {
            Image image = imageService.uploadImage2(imageDto);
            images.add(image);
        }
        Hotel hotel = hotelMapper.dtoToHotelEntity(hotelAddRequest);
        hotel.setImages(images);
        return hotelMapper.entityToHotelResponse(hotelRepository.save(hotel));
    }

//    @Override
//    public List<Hotel> getHotelsByCity(Long cityId) {
//        City city = cityService.findById(cityId);
//        List<Hotel> hotels = hotelRepository.findByCity(city);
//        return hotels;
//    }
}
