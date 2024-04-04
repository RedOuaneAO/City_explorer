package com.example.city_explorer.dto.city;

import com.example.city_explorer.dto.image.ImageDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityAddRequest {
    @NotNull(message = "the name cannot be null.")
    @NotBlank(message = "the name cannot be blank.")
    private String name;
    @NotNull(message = "the description cannot be null.")
    @NotBlank(message = "the description cannot be blank.")
    private String description;
    private List<ImageDto> images;

}
