package com.itb.inf3bn.pizzariaboamassa.dto.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PedidoRequest {

    private BigDecimal valorPedido;
    private LocalDateTime dataHoraPedido;
    private String status;  
    private Long clienteId;

}
