package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.services.FoodService;
import com.example.city_explorer.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class HotelController {
//    private final HotelService hotelService ;
//
//
//    @GetMapping("foods")
//    public List<Hotel> getAll() {
//        return hotelService.getAll();
//    }
//    @PostMapping("food")
//    public String save(@RequestBody Hotel hotel) {
//        return hotelService.save(hotel);
//    }
//    @PutMapping("foodUpdate")
//    public String updateHotel(@RequestBody Hotel hotel) {
//        return hotelService.update(hotel);
//    }
//    @DeleteMapping("DeleteFood")
//    public String deleteHotel(@RequestBody Hotel hotel) {
//        return hotelService.deleteHotel(hotel);
//    }
}
