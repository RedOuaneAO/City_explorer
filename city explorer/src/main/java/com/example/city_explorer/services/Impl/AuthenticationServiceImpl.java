package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.Role;
import com.example.city_explorer.demain.models.User;
import com.example.city_explorer.dto.auth.AuthenticateRequest;
import com.example.city_explorer.dto.auth.AuthenticationResponse;
import com.example.city_explorer.dto.auth.RegisterRequest;
import com.example.city_explorer.services.AuthenticationService;
import com.example.city_explorer.services.JwtService;
import com.example.city_explorer.services.RoleService;
import com.example.city_explorer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private  final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Role role =roleService.findByRole(RoleName.USER);
        var user = User.builder()
                .nationality(request.getNationality())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        var registredUser = userService.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(registredUser.getEmail())
                .authorities(user.getRole().getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).toList())
                .token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        var user = userService.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("user doesn't exist"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .authorities(user.getRole().getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).toList())
                .email(user.getEmail())
                .token(jwtToken).build();
    }
}
