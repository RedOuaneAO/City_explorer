package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.models.RefreshToken;
import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.dto.auth.AuthenticationResponse;
import com.example.city_explorer.dto.auth.RefreshTokenRequest;
import com.example.city_explorer.dto.auth.RefreshTokenResponse;
import com.example.city_explorer.repositories.RefreshTokenRepository;
import com.example.city_explorer.services.JwtService;
import com.example.city_explorer.services.RefreshTokenService;
import com.example.city_explorer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;
    private final UserService userService;

     @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        final String refreshToken;
        final String userEmail;
        refreshToken = refreshTokenRequest.getRefreshToken();
        refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new RuntimeException("this token doesn't exist"));
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            UserDetails userDetails = userService.loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                    var accessToken = jwtService.generateToken(userDetails);
                    RefreshTokenResponse response = RefreshTokenResponse.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshToken)
                            .build();
                    return response;
            }
        }
        return null;
    }

    @Override
    public void save(RefreshToken token) {
        refreshTokenRepository.save(token);
    }

    @Override
    public void deleteOldToken(User user) {
      var refreshToken= refreshTokenRepository.findByUser(user);
      refreshTokenRepository.delete(refreshToken);
    }
}
