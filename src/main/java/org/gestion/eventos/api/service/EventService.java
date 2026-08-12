package org.gestion.eventos.api.service;

import lombok.RequiredArgsConstructor;
import org.gestion.eventos.api.domain.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{
    private final EventService repository;


    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }
}
