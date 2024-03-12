package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);

    UserDetails loadUserByUsername(String userEmail);
}
