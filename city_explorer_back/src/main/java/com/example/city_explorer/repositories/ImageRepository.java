package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image ,Long> {
}
