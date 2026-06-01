package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jovens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cidade;
    private String habilidades;

}
