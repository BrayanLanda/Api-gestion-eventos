package org.gestion.eventos.api.mapper;

import org.gestion.eventos.api.domain.Event;
import org.gestion.eventos.api.dto.EventResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    List<EventResponseDto> toEventResponseDtoList(List<Event> events);
}
