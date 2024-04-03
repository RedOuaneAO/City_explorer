package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.repositories.HotelRepository;
import com.example.city_explorer.services.CityService;
import com.example.city_explorer.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final CityService cityService;
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
                .city(city)
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
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public String deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
        return "success";
    }

    @Override
    public List<Hotel> getHotelsByCity(Long cityId) {
        City city = cityService.findById(cityId);
        List<Hotel> hotels = hotelRepository.findByCity(city);
        return hotels;
    }
}
