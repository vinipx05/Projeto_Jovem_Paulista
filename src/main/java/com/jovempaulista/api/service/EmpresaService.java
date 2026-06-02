package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Empresa;
import com.jovempaulista.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository Repository;

    public List<Empresa> listarTodas() {
        return Repository.findAll();
    }



    public Empresa buscarPorId(long id) {
        return Repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));


    }

    public Empresa salvar(Empresa empresa) {
        return Repository.save(empresa);
    }

    public Empresa atualizar(long id, Empresa dados) {
        Empresa empresa = buscarPorId(id);
        empresa.setRazaoSocial(dados.getRazaoSocial());
        empresa.setSetor(dados.getSetor());
        empresa.setCidade(dados.getCidade());
        empresa.setEstado(dados.getEstado());
        empresa.setDescricao(dados.getDescricao());
        return Repository.save(empresa);
    }

    public void deletar(long id) {
        Repository.deleteById(id);
    }
}
