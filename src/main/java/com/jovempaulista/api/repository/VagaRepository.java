package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.Empresa;
import com.jovempaulista.api.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByAtiva(boolean ativo);
    List<Vaga> findBycidade(String cidade);
    List<Vaga> findByEmpresa(long empresaId);

}