package com.example.city_explorer.demain.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Food> foodList;
    @OneToMany
    private List<Hotel> hotels;
    @OneToMany
    private List<Comment> comments;

}
