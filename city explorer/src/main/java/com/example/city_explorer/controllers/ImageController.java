package com.example.city_explorer.controllers;

import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.repositories.ImageRepository;
import com.example.city_explorer.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    private final ImageService imageService;

    @PostMapping("upload")
    public ResponseEntity<Map> upload(ImageDto imageDto) {
        try {
            return imageService.uploadImage(imageDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
