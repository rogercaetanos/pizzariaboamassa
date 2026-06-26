package com.itb.inf3bn.pizzariaboamassa.dto.categoria;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

    private Long id; 
    private String nome;
    private String descricao;
    private boolean codStatus;

}
