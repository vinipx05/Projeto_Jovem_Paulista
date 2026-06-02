package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Candidatura;
import com.jovempaulista.api.model.Vaga;
import com.jovempaulista.api.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository Repository;

    public List<Candidatura> listarTodas() {
        return Repository.findAll();

    }

    public List<Candidatura>listarPorJovem(long Jovemid){
        return Repository.findByJovemId(Jovemid);

    }

    public List<Candidatura>listarPorVaga(long Vagaid){
        return Repository.findByVagaId(Vagaid);

    }

    public Candidatura buscarporId(long id){
        return Repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Candidatura não encontrada"));

    }

    public Candidatura salvar(Candidatura candidatura){
        candidatura.setDataCandidatura(LocalDate.now());
        candidatura.setStatus("PENDENTE");
        return Repository.save(candidatura);

    }

    public Candidatura atualizarStatus(long id,String status){
        Candidatura candidatura = buscarporId(id);
        candidatura.setStatus(status);
        return Repository.save(candidatura);
    }

    public void deletar(long id){
        Repository.deleteById(id);
    }

}
