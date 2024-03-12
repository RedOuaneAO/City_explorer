package com.example.city_explorer.services;

import com.example.city_explorer.demain.models.RefreshToken;
import com.example.city_explorer.dto.auth.RefreshTokenRequest;
import com.example.city_explorer.dto.auth.RefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public interface RefreshTokenService {
    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    void save(RefreshToken token);
}
