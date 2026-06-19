package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

     // Usando o construtor para injetar a dependência
     
    public FuncionarioService (FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }



}
