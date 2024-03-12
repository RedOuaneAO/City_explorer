package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByRefreshToken(String token);
}
