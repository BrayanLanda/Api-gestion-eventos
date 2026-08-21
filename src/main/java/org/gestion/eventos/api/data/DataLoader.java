package org.gestion.eventos.api.data;

import lombok.RequiredArgsConstructor;
import org.gestion.eventos.api.domain.Role;
import org.gestion.eventos.api.domain.User;
import org.gestion.eventos.api.repository.RoleRepository;
import org.gestion.eventos.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("ROLE_ADMIN");
                    return roleRepository.save(newRole);
                });
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("ROLE_USER");
                    return roleRepository.save(newRole);
                });

        if(userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setName("Administrator");
            admin.setUsername("admin");
            admin.setEmail("aa@example.coom");
            admin.setPassword(passwordEncoder.encode("admin1234"));

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminRoles.add(userRole);

            admin.setRoles(adminRoles);

            userRepository.save(admin);
        }

        if(userRepository.findByUsername("user").isEmpty()){
            User regularUser = new User();
            regularUser.setName("Normal user");
            regularUser.setUsername("user");
            regularUser.setEmail("bb@example.coom");
            regularUser.setPassword(passwordEncoder.encode("user1234"));

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            regularUser.setRoles(userRoles);

            userRepository.save(regularUser);
        }
    }
}
