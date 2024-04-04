package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import com.example.city_explorer.dto.city.CityAddRequest;
import com.example.city_explorer.dto.city.CityResponse;
import com.example.city_explorer.dto.hotel.HotelAddRequest;
import com.example.city_explorer.dto.hotel.HotelResponse;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.services.FoodService;
import com.example.city_explorer.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService ;
    @GetMapping("hotels")
    public List<HotelResponse> getAll() {
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
//    @GetMapping("cityHotels/{id}")
//    public List<Hotel> getHotelsByCity( @PathVariable Long id) {
//        return hotelService.getHotelsByCity(id);
//    }
    @PostMapping("addHotel")
    public ResponseEntity<HotelResponse> saveCity(@Valid @RequestParam("name") String name,
                                                  @Valid @RequestParam("description") String description,
                                                  @Valid @RequestParam("cityId") Long cityId,
                                                  @RequestParam("images") List<MultipartFile> imageFiles) {
        List<ImageDto> images = imageFiles.stream()
                .map(file -> ImageDto.builder().file(file).build())
                .collect(Collectors.toList());
        HotelAddRequest hotelAddRequest = HotelAddRequest.builder()
                .name(name)
                .description(description)
                .images(images)
                .cityId(cityId)
                .build();
        return ResponseEntity.ok(hotelService.saveHotel(hotelAddRequest));
    }
}
