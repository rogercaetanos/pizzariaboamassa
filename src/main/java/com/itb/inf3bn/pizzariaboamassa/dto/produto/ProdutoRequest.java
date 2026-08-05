package com.itb.inf3bn.pizzariaboamassa.dto.produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    private String nome;
    private String descricao;
    private double valorVenda;
    private double valorCompra;
    private String tipo;
    private int quantidadeEstoque;
    private Long categoriaId;

}


