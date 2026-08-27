package org.gestion.eventos.api.mapper;

import org.gestion.eventos.api.domain.User;
import org.gestion.eventos.api.dto.RegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    User registerDtoToUser(RegisterDto registerDto);
}
