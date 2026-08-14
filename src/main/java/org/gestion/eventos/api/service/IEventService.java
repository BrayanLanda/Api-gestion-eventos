package org.gestion.eventos.api.service;

import org.gestion.eventos.api.domain.Event;

import java.util.List;

public interface IEventService {
    List<Event> findAll();
    Event save(Event event);
    Event findById(Long id);
}
