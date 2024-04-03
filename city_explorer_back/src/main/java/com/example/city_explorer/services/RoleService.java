package com.example.city_explorer.services;

import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findByRole(RoleName roleName);
}
