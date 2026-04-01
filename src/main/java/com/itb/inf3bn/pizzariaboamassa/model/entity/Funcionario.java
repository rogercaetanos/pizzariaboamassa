package com.itb.inf3bn.pizzariaboamassa.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("FUNCIONARIO")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Usuario {

    @Column(length = 15, nullable = true)
    private String cnh;
}
