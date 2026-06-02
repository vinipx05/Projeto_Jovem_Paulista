package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Jovem;
import com.jovempaulista.api.repository.JovemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JovemService {

    @Autowired
    private JovemRepository repository;

    public List<Jovem> listarTodos() {
        return repository.findAll();
    }

    public Jovem buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Jovem não encontrado"));

    }

    public Jovem salvar(Jovem jovem) {
        return repository.save(jovem);
    }

    public Jovem atualizar(long id, Jovem dados) {
        Jovem jovem = buscarPorId(id);
        jovem.setCidade(dados.getCidade());
        jovem.setEstado(dados.getEstado());
        jovem.setEscolaridade(dados.getEscolaridade());
        jovem.setResumo(dados.getResumo());
        return repository.save(jovem);

    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
