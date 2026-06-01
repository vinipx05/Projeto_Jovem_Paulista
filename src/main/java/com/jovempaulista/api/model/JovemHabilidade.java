package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jovem_habilidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JovemHabilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jovem_id")
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "habilidade_id")
    private Habilidade habilidade;

    private String nivel;

}
