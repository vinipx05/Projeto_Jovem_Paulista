package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Candidatura;
import com.jovempaulista.api.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository repository;

    public List<Candidatura> listarTodas() {
        return repository.findAll();
    }

    public List<Candidatura> listarPorJovem(Long jovemId) {
        return repository.findByJovemId(jovemId);
    }

    public List<Candidatura> listarPorVaga(Long vagaId) {
        return repository.findByVagaId(vagaId);
    }

    public Candidatura buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
    }

    public Candidatura salvar(Candidatura candidatura) {
        candidatura.setDataCandidatura(LocalDate.now());
        candidatura.setStatus("PENDENTE");
        return repository.save(candidatura);
    }

    public Candidatura atualizarStatus(Long id, String status) {
        Candidatura candidatura = buscarPorId(id);
        candidatura.setStatus(status);
        return repository.save(candidatura);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
