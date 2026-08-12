package org.gestion.eventos.api.controller;

import lombok.RequiredArgsConstructor;
import org.gestion.eventos.api.domain.Event;
import org.gestion.eventos.api.dto.EventRequestDto;
import org.gestion.eventos.api.dto.EventResponseDto;
import org.gestion.eventos.api.mapper.EventMapper;
import org.gestion.eventos.api.service.IEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public List<EventResponseDto> getAllEvents(){
        List<Event> events = eventService.findAll();
        return eventMapper.toEventResponseDtoList(events);
    }

    @PostMapping
    public EventResponseDto createEvent(@RequestBody EventRequestDto requestDto){
        Event eventToSaved = eventMapper.toEntity(requestDto);
        Event eventSaved = eventService.save(eventToSaved);
        return eventMapper.toResponseDto(eventSaved);
    }
}
