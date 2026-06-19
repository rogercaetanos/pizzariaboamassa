package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.UsuarioRepository;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

     // Usando o construtor para injetar a dependência
     
    public UsuarioService (UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

}
