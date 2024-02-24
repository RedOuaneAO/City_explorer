package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.Hotel;

import java.util.List;

public interface HotelService {

    String update(Hotel hotel);

    String save(Hotel hotel);

    List<Hotel> getAll();

    String deleteHotel(Hotel hotel);
}
