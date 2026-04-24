package com.example.reyes_toval5c_recu2.controller;

import com.example.reyes_toval5c_recu2.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PatchMapping("/estado/{usuarioID}")
    public ResponseEntity<String> cambiarEstadoUsuario(@PathVariable Long usuarioID) {

        String response = usuarioService.cambiarEstadoUsuario(usuarioID);

        return ResponseEntity.ok(response);
    }


}

