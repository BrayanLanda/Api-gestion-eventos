package org.gestion.eventos.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.gestion.eventos.api.domain.Event;
import org.gestion.eventos.api.dto.EventRequestDto;
import org.gestion.eventos.api.dto.EventResponseDto;
import org.gestion.eventos.api.mapper.EventMapper;
import org.gestion.eventos.api.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto requestDto){
        Event eventToSaved = eventMapper.toEntity(requestDto);
        Event eventSaved = eventService.save(eventToSaved);
        EventResponseDto responseDto = eventMapper.toResponseDto(eventSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id){
        Event event = eventService.findById(id);
        EventResponseDto responseDto = eventMapper.toResponseDto(event);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequestDto requestDto){
        Event eventToUpdate = eventService.findById(id);
        eventMapper.updateEventFromDto(requestDto, eventToUpdate);
        Event updateEvent = eventService.save(eventToUpdate);
        return ResponseEntity.ok(eventMapper.toResponseDto(updateEvent));
    }
}
