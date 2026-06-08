package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String tipo;
    private String telefone;
    private LocalDate dataCadastro;
    private Boolean ativo;
    private String role; // "ROLE_USER" ou "ROLE_ADMIN"
}