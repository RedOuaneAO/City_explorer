package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Food findByName(String name);

    List<Food> findByCity(City city);
}
