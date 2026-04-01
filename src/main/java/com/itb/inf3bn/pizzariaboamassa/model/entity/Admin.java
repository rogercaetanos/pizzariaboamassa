package com.itb.inf3bn.pizzariaboamassa.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("ADMIN")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Usuario{

    @Column(length = 20, nullable = true)
    private String nivelAcesso;


}
