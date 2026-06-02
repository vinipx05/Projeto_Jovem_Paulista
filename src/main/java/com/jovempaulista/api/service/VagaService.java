package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Vaga;
import com.jovempaulista.api.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository Repository;

    public List<Vaga> listarTodas() {
        return Repository.findAll();
    }

    public List<Vaga> listarAtivas() {
        return Repository.findByAtiva(true);
    }

    public Vaga buscarPorId(Long id) {
        return Repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Vaga não encontrada"));

    }

    public Vaga salvar(Vaga vaga) {
        vaga.setAtiva(true);
        return Repository.save(vaga);
    }

    public Vaga atualizar(long id, Vaga dados) {
        Vaga vaga = buscarPorId(id);
        vaga.setTitulo(vaga.getTitulo());
        vaga.setDescricao(vaga.getDescricao());
        vaga.setTipo(vaga.getTipo());
        vaga.setModalidade(vaga.getModalidade());
        vaga.setCidade(vaga.getCidade());
        vaga.setSalario(vaga.getSalario());
        vaga.setDataEncerramento(vaga.getDataEncerramento());
        return Repository.save(vaga);
    }

    public void deletar(long id) {
        Repository.deleteById(id);
    }
}
