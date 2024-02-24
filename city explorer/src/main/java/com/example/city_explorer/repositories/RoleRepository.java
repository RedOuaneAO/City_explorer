package com.example.city_explorer.repositories;

import com.example.city_explorer.demain.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
