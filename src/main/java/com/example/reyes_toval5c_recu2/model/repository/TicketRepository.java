package com.example.reyes_toval5c_recu2.model.repository;

import com.example.reyes_toval5c_recu2.model.Ticket;
import com.example.reyes_toval5c_recu2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findByUsuario(Usuario usuario);

}
