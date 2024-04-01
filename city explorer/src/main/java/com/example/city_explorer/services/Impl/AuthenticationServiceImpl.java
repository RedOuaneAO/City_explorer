package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.RefreshToken;
import com.example.city_explorer.demain.models.Role;
import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.dto.auth.AuthenticateRequest;
import com.example.city_explorer.dto.auth.AuthenticationResponse;
import com.example.city_explorer.dto.auth.RegisterRequest;
import com.example.city_explorer.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private  final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RefreshTokenService refreshTokenService;
    private final ImageService imageService;
    @Value("${application.security.jwt.secretkey.refreshToken.experation}")
    private Long refershExperation;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Role role =roleService.findByRole(RoleName.USER);
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationality(request.getNationality())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        var registredUser = userService.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refershToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .email(registredUser.getEmail())
                .authorities(user.getRole().getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).toList())
                .token(jwtToken)
                .refreshToken(refershToken)
                .build();
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        System.out.println(request);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        var user = userService.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("user doesn't exist"));
        System.out.println(user);
        refreshTokenService.deleteOldToken(user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println(jwtToken);
        var refershToken = jwtService.generateRefreshToken(user);
        saveUserToken(user,refershToken);
        return AuthenticationResponse.builder()
                .authorities(user.getRole().getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).toList())
                .email(user.getEmail())
                .token(jwtToken)
                .refreshToken(refershToken)
                .build();
    }



    private void saveUserToken(User user,String refreshToken){
            var token= RefreshToken.builder()
                    .refreshToken(refreshToken)
                    .revoked(false)
                    .experationDate(Instant.now().plusMillis(refershExperation))
                    .user(user)
                    .build();
            refreshTokenService.save(token);
    }
    private void logOut(User user){

    }
}
