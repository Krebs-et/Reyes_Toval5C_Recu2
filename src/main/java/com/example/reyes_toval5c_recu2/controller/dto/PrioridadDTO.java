package com.example.reyes_toval5c_recu2.controller.dto;

import com.example.reyes_toval5c_recu2.model.enums.Prioridad;

public record PrioridadDTO(
        Long ticketId,
        Prioridad prioridad
) {
}
