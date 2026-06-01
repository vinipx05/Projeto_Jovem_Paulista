package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habilidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

}
