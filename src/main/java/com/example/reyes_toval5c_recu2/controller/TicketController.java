package com.example.reyes_toval5c_recu2.controller;

import com.example.reyes_toval5c_recu2.controller.dto.PrioridadDTO;
import com.example.reyes_toval5c_recu2.controller.dto.TicketDTO;
import com.example.reyes_toval5c_recu2.model.Ticket;
import com.example.reyes_toval5c_recu2.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearTicket(@RequestBody TicketDTO ticket) {

        String response = ticketService.crearTicket(ticket);

        return ResponseEntity.ok(response);

    }

    @PatchMapping("/estado/{id}")
    public ResponseEntity<String> actualizarEstadoTicket(@PathVariable Long id) {
        String response = ticketService.actualizarEstadoTicket(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/prioridad")
    public ResponseEntity<String> actualizarPrioridadTicket(@RequestBody PrioridadDTO prioridadDTO) {

        String response = ticketService.reasignarPrioridad(prioridadDTO);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/tickets/{idUsuario}")
    public ResponseEntity<List<Ticket>> getTickets(@PathVariable Long idUsuario) {

        List<Ticket> tickets = ticketService.obtenerTicketsUsuario(idUsuario);

        return ResponseEntity.ok(tickets);

    }


}
