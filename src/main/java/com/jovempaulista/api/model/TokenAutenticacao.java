package com.jovempaulista.api.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tokens_autenticacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenAutenticacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String token;
    private  LocalDateTime expiracao;
    private Boolean ativo;

}
