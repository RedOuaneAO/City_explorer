package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.image.ImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ImageService {
    ResponseEntity<Map> uploadImage(ImageDto imageDto);

    Image uploadImage2(ImageDto image);
}
