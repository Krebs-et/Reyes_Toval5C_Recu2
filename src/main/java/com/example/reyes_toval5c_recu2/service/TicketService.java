package com.example.reyes_toval5c_recu2.service;

import com.example.reyes_toval5c_recu2.controller.dto.PrioridadDTO;
import com.example.reyes_toval5c_recu2.controller.dto.TicketDTO;
import com.example.reyes_toval5c_recu2.model.Ticket;
import com.example.reyes_toval5c_recu2.model.Usuario;
import com.example.reyes_toval5c_recu2.model.enums.Estado;
import com.example.reyes_toval5c_recu2.model.enums.Prioridad;
import com.example.reyes_toval5c_recu2.model.repository.TicketRepository;
import com.example.reyes_toval5c_recu2.model.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;


    public String crearTicket(@Valid TicketDTO ticket) {


        Usuario u = getUsuario(ticket.usuarioId());

        if (!u.isActivo()) {
            throw new IllegalArgumentException("Usuario no inactivo");
        }

        // Se crea el estado desde el constructor personalizado y ahí se crea como abierto.

        Ticket ticketEntity = new Ticket(
                u,
                ticket.descripcion(),

                // Se toma la prioridad desde el DTO (Limitado al ENUM Prioridad).
                ticket.prioridad()
        );

        // Guardamos el ticket.
        ticketRepository.save(ticketEntity);

        return "Ticket creado con éxito.";

    }

    public String actualizarEstadoTicket(Long ticketId) {

        Ticket t = getTicket(ticketId);

        if (t.getEstado() == Estado.ABIERTO) {
            t.setEstado(Estado.EN_PROCESO);
        } else if (t.getEstado() == Estado.EN_PROCESO) {
            t.setEstado(Estado.CERRADO);
        } else if (t.getEstado() == Estado.CERRADO) {

            throw new IllegalStateException("Este ticket ya no se puede modificar");

            // Pudiera usarse también
            // return "Este ticket ya no se puede modificar";

        }

        ticketRepository.save(t);

        return "Ticket modificado a: " + t.getEstado().toString();

    }

    public String reasignarPrioridad(PrioridadDTO dto) {

        Ticket t = getTicket(dto.ticketId());
        if (t.getEstado() == Estado.CERRADO) {
            throw new IllegalStateException("Este ticket ya no se puede modificar");
        } else if (t.getPrioridad() == dto.prioridad()) {
            return "El ticket ya se encuentra en prioridad: " + t.getPrioridad().toString();
        }

        ticketRepository.save(t);

        return "Ticket reasignado a: " + t.getPrioridad().toString();
    }

    public List<Ticket> obtenerTicketsUsuario(Long usuarioId) {

        Usuario u = getUsuario(usuarioId);

        return ticketRepository.findByUsuario(u);

    }

    private Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Ticket no encontrado"));
    }

    private Usuario getUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }


}
