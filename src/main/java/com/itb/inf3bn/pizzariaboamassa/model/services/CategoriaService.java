package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

     // Usando o construtor para injetar a dependência
     
    public CategoriaService (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }



}
