package com.example.city_explorer.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserRegisterResponse {
    private String fullName;
    private String nationality;
    private String email;
    private String role;
}
