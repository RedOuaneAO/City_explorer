package com.example.city_explorer.demain.models;

import com.example.city_explorer.demain.enums.AuthorityName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AuthorityName authority;
    @ManyToMany(mappedBy = "authorities")
    private List<Role> roles;
}