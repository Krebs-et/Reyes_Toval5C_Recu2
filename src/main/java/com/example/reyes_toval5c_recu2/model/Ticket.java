package com.example.reyes_toval5c_recu2.model;

import com.example.reyes_toval5c_recu2.model.enums.Estado;
import com.example.reyes_toval5c_recu2.model.enums.Prioridad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    private String descripcion;

    @Setter
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    public Ticket(Usuario usuario, String descripcion, Prioridad prioridad) {

        this.usuario = usuario;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = Estado.ABIERTO;

    }

}
