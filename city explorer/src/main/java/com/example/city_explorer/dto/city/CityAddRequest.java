package com.example.city_explorer.dto.city;

import com.example.city_explorer.demain.models.Comment;
import com.example.city_explorer.demain.models.Food;
import com.example.city_explorer.demain.models.Hotel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityAddRequest {

    private String name;
    private String description;
//    @OneToMany
//    private List<Long> foodList;
//    @OneToMany
//    private List<Long> hotels;

}
