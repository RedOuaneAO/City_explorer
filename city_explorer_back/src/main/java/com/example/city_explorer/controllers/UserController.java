package com.example.city_explorer.controllers;

import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.dto.auth.AuthenticationResponse;
import com.example.city_explorer.dto.auth.RegisterRequest;
import com.example.city_explorer.dto.user.UpdateProfileRequest;
import com.example.city_explorer.services.UserService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("users/{token}")
    public User getUserByUserName(@PathVariable("token") String token){
        return userService.getUserByUserName(token);
    }

    @PutMapping("updateProfile")
    public void updateProfile(@ModelAttribute UpdateProfileRequest profileRequest , ServletRequest request){
            userService.updateProfile(profileRequest , request);
    }
}
