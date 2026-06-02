package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura,Long> {
    List<Candidatura> findByJovemId(long jovemId);
    List<Candidatura> findByVagaId(long vagaId);
    List<Candidatura> findByStatus(String status);

}