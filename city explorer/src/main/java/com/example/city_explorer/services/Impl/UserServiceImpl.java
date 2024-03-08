package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.repositories.UserRepository;
import com.example.city_explorer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
