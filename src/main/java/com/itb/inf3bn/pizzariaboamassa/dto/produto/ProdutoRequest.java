package com.itb.inf3bn.pizzariaboamassa.dto.produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {


    private Long id;
    private String nome;
    private String descricao;
    private double valorVenda;
    private double valorCompra;
    private String tipo;
    private int quantidadeEstoque;
    private boolean codStatus;
    private Long categoriaId;

}


