package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRole(RoleName roleName);
}
