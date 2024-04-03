package com.example.city_explorer.seeder;

import com.example.city_explorer.demain.enums.AuthorityName;
import com.example.city_explorer.demain.enums.RoleName;
import com.example.city_explorer.demain.models.Authority;
import com.example.city_explorer.demain.models.Role;
import com.example.city_explorer.repositories.AuthorityRepository;
import com.example.city_explorer.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    @Override
    public void run(String... args) throws Exception {
        Authority authority1= seedAuthority(AuthorityName.CAN_ADD);
        Authority authority2= seedAuthority(AuthorityName.CAN_EDIT);
        Authority authority3= seedAuthority(AuthorityName.CAN_DELETE);
        Authority authority4= seedAuthority(AuthorityName.CAN_VIEW);

        seedRole(RoleName.ADMIN , List.of(authority1, authority2,authority4));
        seedRole(RoleName.USER , List.of(authority4));
    }
    private Authority seedAuthority(AuthorityName authorityType){
        Optional<Authority> existAuthority = authorityRepository.findByAuthority(authorityType);
        if(existAuthority.isEmpty()){
            Authority authority = Authority.builder().authority(authorityType).build();
            authorityRepository.save(authority);
            return authority;
        }
        return existAuthority.get();
    }
    private Role seedRole(RoleName roleName , List<Authority> authorities){
        Optional<Role> existRole = roleRepository.findByRole(roleName);
        if(existRole.isEmpty()){
            Role role = Role.builder().role(roleName).authorities(authorities).build();
            return  roleRepository.save(role);
        }
        return null;
    }
}
