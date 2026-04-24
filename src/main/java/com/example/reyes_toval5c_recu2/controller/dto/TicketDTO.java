package com.example.reyes_toval5c_recu2.controller.dto;


import com.example.reyes_toval5c_recu2.model.enums.Prioridad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketDTO(

        @NotNull
        Long usuarioId,

        @NotBlank
        @NotNull
        String descripcion,

        @NotNull
        @NotBlank
        Prioridad prioridad

) {
}
