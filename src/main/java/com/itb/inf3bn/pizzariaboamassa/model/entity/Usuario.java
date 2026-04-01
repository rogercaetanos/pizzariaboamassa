package com.itb.inf3bn.pizzariaboamassa.model.entity;

import com.itb.inf3bn.pizzariaboamassa.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity                            // Entidade
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario",  discriminatorType = DiscriminatorType.STRING)
@Setter    // Atribuir valor ao atributo
@Getter    // Recuperar valor do atributo
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Evita duplicidade em coleções e otimiza a busca
@NoArgsConstructor   // Construtor padrão (sem argumentos)
@AllArgsConstructor // Construtor com todos atributos
@Builder             // Forma diferenciada para criar objetos
public class Usuario {

    @Id                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK será gerado automaticamente, identificado de 1 em 1
    @EqualsAndHashCode.Include
    private Long id;
    @Column(length = 45, nullable = true)
    private String nome;
    @Column(length = 20, nullable = true)
    private String cpf;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(nullable = true)
    private LocalDate dataNascimento;
    @Column(length = 255, nullable = false)
    private String senha;
    @Column(length = 15, nullable = true)
    public String sexo;
    @Column(length = 45, nullable = true)
    public String logradouro;
    @Column(length = 10, nullable = true)
    public String cep;
    @Column(length = 45, nullable = true)
    public String bairro;
    @Column(length = 30, nullable = true)
    public String cidade;
    @Column(length = 2, nullable = true)
    public String uf;
    public boolean codStatus;

    @Enumerated(EnumType.STRING)  // Transformando o enum para String
    @Column(length = 20, name = "tipo_usuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

}
