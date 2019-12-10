package com.invillia.minhasFinancas.model.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table (name = "usuario")
@Builder
@Data
public class Usuario {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
