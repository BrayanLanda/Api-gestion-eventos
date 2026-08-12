package org.gestion.eventos.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventRequestDto {
    @NotBlank(message = "El nombre del evento no puede estar vacio.")
    private String name;

    @NotNull(message = "La fecha no puede estar nula")
    private LocalDate date;

    @NotBlank(message = "La ubicacion no puede estar vacia")
    private String location;
}
