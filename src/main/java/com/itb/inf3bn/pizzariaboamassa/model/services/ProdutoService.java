package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

     // Usando o construtor para injetar a dependência
     
    public ProdutoService (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }



}
