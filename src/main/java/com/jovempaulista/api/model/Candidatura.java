package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jovem_id")
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private LocalDate dataCandidatura;
    private String status;
    private String observacao;

}
