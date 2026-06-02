package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.TokenAutenticacao;
import com.jovempaulista.api.model.VagaHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TokenAutenticacaoRepository  extends JpaRepository<VagaHabilidade,Long> {
    Optional<TokenAutenticacao> findBytoken(String token);
    List<TokenAutenticacao> findByusuarioId(long usuarioId);

}
