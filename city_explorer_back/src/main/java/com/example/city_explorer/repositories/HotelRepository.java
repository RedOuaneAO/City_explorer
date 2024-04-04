package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.City;
import com.example.city_explorer.demain.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Hotel findByName(String name);

//    List<Hotel> findByCity(City city);
}
