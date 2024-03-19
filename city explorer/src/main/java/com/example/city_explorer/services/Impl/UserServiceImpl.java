package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.repositories.UserRepository;
import com.example.city_explorer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
            return userRepository.save(user);
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) {
        return userRepository.findByEmail(userEmail).orElseThrow(()->new RuntimeException("this email doesn't exist"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
