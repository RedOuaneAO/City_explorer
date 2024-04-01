package com.example.city_explorer.dto.city;

import com.example.city_explorer.dto.image.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityAddRequest {

    private String name;
    private String description;
    private List<ImageDto> images;
//    @OneToMany
//    private List<Long> foodList;
//    @OneToMany
//    private List<Long> hotels;

}
