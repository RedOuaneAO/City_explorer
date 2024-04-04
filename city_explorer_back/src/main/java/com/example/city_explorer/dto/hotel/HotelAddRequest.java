package com.example.city_explorer.dto.hotel;

import com.example.city_explorer.dto.image.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelAddRequest {
    private String name;
    private String description;
    private List<ImageDto> images;
    private Long cityId;
}
