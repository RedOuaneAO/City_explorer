package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.RefreshToken;
import com.example.city_explorer.demain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByRefreshToken(String token);

    RefreshToken findByUser(User user);
}
