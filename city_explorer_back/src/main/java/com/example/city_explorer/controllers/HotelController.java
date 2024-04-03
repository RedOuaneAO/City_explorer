package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.services.FoodService;
import com.example.city_explorer.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService ;
    @GetMapping("hotels")
    public List<Hotel> getAll() {
        return hotelService.getAll();
    }
    @PostMapping("hotel")
    public String save(@RequestBody HotelAddRequest hotel) {
        return hotelService.save(hotel);
    }
    @PutMapping("hotelUpdate")
    public String updateHotel(@RequestBody Hotel hotel) {
        return hotelService.update(hotel);
    }
    @DeleteMapping("DeleteHotel")
    public String deleteHotel(@RequestBody Hotel hotel) {
        return hotelService.deleteHotel(hotel);
    }
    @GetMapping("cityHotels/{id}")
    public List<Hotel> getHotelsByCity( @PathVariable Long id) {
        return hotelService.getHotelsByCity(id);
    }
}
