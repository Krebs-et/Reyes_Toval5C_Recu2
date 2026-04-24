package com.example.reyes_toval5c_recu2.service;

import com.example.reyes_toval5c_recu2.model.Usuario;
import com.example.reyes_toval5c_recu2.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public String cambiarEstadoUsuario(Long usuarioId){

        Usuario usuario = getUsuario(usuarioId);

        if (usuario.isActivo()) {
            usuario.setActivo(false);
        } else {
            usuario.setActivo(true);
        }

        usuarioRepository.save(usuario);

        return "Usuario actualizado con éxito.";
    }


    private Usuario getUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
