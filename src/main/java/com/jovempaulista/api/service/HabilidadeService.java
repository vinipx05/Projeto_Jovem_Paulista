package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Habilidade;
import com.jovempaulista.api.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository repository;

    public List<Habilidade> listarTodas() {
        return repository.findAll();
    }

    public Habilidade buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
    }

    public Habilidade salvar(Habilidade habilidade) {
        return repository.save(habilidade);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
