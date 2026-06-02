package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.TokenAutenticacao;
import com.jovempaulista.api.model.TokenAutenticacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TokenAutenticacaoRepository extends JpaRepository<TokenAutenticacao, Long> {
    Optional<TokenAutenticacao> findByToken(String token);
    List<TokenAutenticacao> findByUsuarioId(Long usuarioId);
}
