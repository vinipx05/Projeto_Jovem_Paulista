package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.VagaHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaHabilidadeRepository extends JpaRepository<VagaHabilidade, Long> {
    List<VagaHabilidade> findByVagaId(Long vagaId);
    List<VagaHabilidade> findByObrigatoria(Boolean obrigatoria);
}