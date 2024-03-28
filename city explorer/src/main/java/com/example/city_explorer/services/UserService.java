package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.dto.user.UpdateProfileRequest;
import jakarta.servlet.ServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);

    UserDetails loadUserByUsername(String userEmail);

    List<User> getAll();

    User getUserByUserName(String token);


    void updateProfile(UpdateProfileRequest profileRequest, ServletRequest request);
}
