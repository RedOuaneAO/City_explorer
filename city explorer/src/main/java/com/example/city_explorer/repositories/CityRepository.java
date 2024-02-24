package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
