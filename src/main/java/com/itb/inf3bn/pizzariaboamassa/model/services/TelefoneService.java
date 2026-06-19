package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.TelefoneRepository;


@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

     // Usando o construtor para injetar a dependência
     
    public TelefoneService (TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

}
