package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.dto.hotel.HotelResponse;

import java.util.List;

public interface HotelService {

    String update(Hotel hotel);

    String save(HotelAddRequest hotel);

    List<HotelResponse> getAll();

    String deleteHotel(Hotel hotel);

    HotelResponse saveHotel(HotelAddRequest hotelAddRequest);

    List<Hotel> getHotelsByCity(Long cityId);
}
