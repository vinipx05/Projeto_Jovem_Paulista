package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.JovemHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JovemHabilidadeRepository  extends JpaRepository<JovemHabilidade,Long> {
    List<JovemHabilidade> findByJovemId(long jovemId);
    List<JovemHabilidade> findByHabilidadeId(long habilidadeId);

}