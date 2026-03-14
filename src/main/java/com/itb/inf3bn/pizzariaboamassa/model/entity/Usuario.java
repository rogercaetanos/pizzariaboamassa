package com.itb.inf3bn.pizzariaboamassa.model.entity;

import com.itb.inf3bn.pizzariaboamassa.model.enums.TipoUsuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity                            // Entidade
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario",  discriminatorType = DiscriminatorType.STRING)
public class Usuario {

    @Id                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK será gerado automaticamente, identificado de 1 em 1
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String senha;
    public String sexo;
    public String logradouro;
    public String cep;
    public String bairro;
    public String cidade;
    public String uf;
    public boolean codStatus;

    @Enumerated(EnumType.STRING)  // Transformando o enum para String
    @Column(name = "tipo_usuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

}
