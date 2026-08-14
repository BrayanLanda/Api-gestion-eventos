package org.gestion.eventos.api.service;

import lombok.RequiredArgsConstructor;
import org.gestion.eventos.api.domain.Event;
import org.gestion.eventos.api.exception.ResourceNotFoundException;
import org.gestion.eventos.api.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{
    private final EventRepository repository;


    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Event not found with id: " + id)
        );
    }
}
