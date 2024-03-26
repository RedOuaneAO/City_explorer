package com.example.city_explorer.dto.user;

import com.example.city_explorer.demain.models.Role;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private String nationality;
    private String role;
}
