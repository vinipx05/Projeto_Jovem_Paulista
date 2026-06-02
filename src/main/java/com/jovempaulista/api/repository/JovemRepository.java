package com.jovempaulista.api.repository;

import com.jovempaulista.api.model.Jovem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JovemRepository extends JpaRepository<Jovem,Long> {
    List<Jovem> findBycidade(String cidade);
    List<Jovem> findByestado(String estado);

}
