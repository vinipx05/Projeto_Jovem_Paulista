package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findBycnpj(String cnpj);
    List<Empresa> findBycidade(String cidade);

}
