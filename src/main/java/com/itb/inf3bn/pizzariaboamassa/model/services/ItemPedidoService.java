package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.ItemPedidoRepository;


@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

     // Usando o construtor para injetar a dependência
     
    public ItemPedidoService (ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

}
