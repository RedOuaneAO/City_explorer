package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.Image;
import com.example.city_explorer.dto.image.ImageDto;
import com.example.city_explorer.repositories.ImageRepository;
import com.example.city_explorer.services.CloudinaryService;
import com.example.city_explorer.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final CloudinaryService cloudinaryService;

    private final ImageRepository imageRepository;


    @Override
    public Image uploadImage2(ImageDto image) {
        try {
            if (image.getFile().isEmpty()) {
               throw new RuntimeException("no image selected");
            }
            Image imagee = Image.builder().imageUrl(cloudinaryService.uploadFile(image.getFile(), "folder_1")).build();
            if(imagee.getImageUrl() == null) {
               throw new RuntimeException("Internal server error. Please try again later.");
            }
            imageRepository.save(imagee);
            return imagee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public ResponseEntity<Map> uploadImage(ImageDto imageDto) {
        try {
            if (imageDto.getFile().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Image image = Image.builder().imageUrl(cloudinaryService.uploadFile(imageDto.getFile(), "folder_1")).build();
            if(image.getImageUrl() == null) {
                return ResponseEntity.badRequest().build();
            }
            imageRepository.save(image);
            return ResponseEntity.ok().body(Map.of("url", image.getImageUrl()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
