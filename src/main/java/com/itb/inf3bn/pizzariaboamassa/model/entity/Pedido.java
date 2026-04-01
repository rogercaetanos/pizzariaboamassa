package com.itb.inf3bn.pizzariaboamassa.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedido")
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(length = 10, nullable = false)
    private String numeroPedido;
    @Column(nullable = false)
    private BigDecimal valorPedido;
    @Column(nullable = false)
    private LocalDateTime dataHoraPedido;
    @Column( nullable = true)
    private LocalDateTime dataHoraEntrega;
    @Column(length = 20, nullable = false)
    private String status;
    private boolean codStatus;

    // Relacionamento
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id",  nullable = false)
    private Cliente cliente;

}
