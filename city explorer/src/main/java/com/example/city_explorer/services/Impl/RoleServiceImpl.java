package com.example.city_explorer.services.Impl;

import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.Role;
import com.example.city_explorer.repositories.RoleRepository;
import com.example.city_explorer.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findByRole(RoleName roleName) {
        return roleRepository.findByRole(roleName).orElseThrow(()->new RuntimeException("this role doesn't exist"));
    }
}
