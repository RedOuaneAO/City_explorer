package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.enums.AuthorityName;
import com.example.city_explorer.demain.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AuthorityRepository  extends JpaRepository<Authority,Long> {
    Optional<Authority> findByAuthority(AuthorityName authorityName);
}
