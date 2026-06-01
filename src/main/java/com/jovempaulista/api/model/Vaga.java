package com.jovempaulista.api.model;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vagas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private String titulo;
    private String descricao;
    private String tipo;
    private String modalidade;
    private String cidade;
    private String estado;
    private BigDecimal salario;
    private LocalDate dataPublicacao;
    private LocalDate dataEncerramento;
    private boolean ativa;

}
