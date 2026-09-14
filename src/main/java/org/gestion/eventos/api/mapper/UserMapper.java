package org.gestion.eventos.api.mapper;

import org.gestion.eventos.api.domain.Role;
import org.gestion.eventos.api.domain.User;
import org.gestion.eventos.api.dto.RegisterDto;
import org.gestion.eventos.api.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected RoleRepository roleRepository;
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract User registerDtoToUser(RegisterDto registerDto);

    public Set<Role> mapRoleStringToRoles(Set<String> roleNames){
        if(roleNames == null || roleNames.isEmpty()){
            return roleRepository.findByName("ROLE_USER")
                    .map(Collections::singleton)
                    .orElseThrow(
                            () -> new RuntimeException("Error: Role 'ROLE_USER' not found in the database;" +
                                    " make sure the role ROLE_USER exists when you submit the request ")
                    );
        }
        return roleNames.stream()
                .map(
                        roleName -> roleRepository.findByName(roleName)
                                .orElseThrow(
                                        () -> new RuntimeException("Error: Role not found: " + roleName)))
                .collect(Collectors.toSet());
    }
}
