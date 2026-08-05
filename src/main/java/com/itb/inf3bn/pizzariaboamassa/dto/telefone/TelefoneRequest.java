package com.itb.inf3bn.pizzariaboamassa.dto.telefone;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelefoneRequest {
  
    private String numero;
    private String ddd;
    private String tipo;
    private Long usuarioId;

}
