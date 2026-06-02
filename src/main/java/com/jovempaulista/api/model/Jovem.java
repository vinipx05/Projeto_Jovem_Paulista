package com.jovempaulista.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "jovens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Usuario usuario;

    private String cpf;
    private LocalDate dataNascimento;
    private String cidade;
    private String estado;
    private String escolaridade;
    private String resumo;

}