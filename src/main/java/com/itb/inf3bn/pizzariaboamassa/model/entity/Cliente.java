package com.itb.inf3bn.pizzariaboamassa.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario{

    private String numeroPontos;
}


