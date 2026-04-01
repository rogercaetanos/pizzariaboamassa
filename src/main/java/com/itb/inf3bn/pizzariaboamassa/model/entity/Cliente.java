package com.itb.inf3bn.pizzariaboamassa.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("CLIENTE")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{

    @Column(length = 10, nullable = true)
    private String numeroPontos;
}


