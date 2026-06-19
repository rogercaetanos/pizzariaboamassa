package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

     // Usando o construtor para injetar a dependência
     
    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }



}
