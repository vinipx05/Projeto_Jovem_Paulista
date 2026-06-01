package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vaga_habilidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaHabilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "habilidade_id")
    private Habilidade habilidade;

    private Boolean obrigatoria;

}
