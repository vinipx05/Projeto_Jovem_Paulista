package com.jovempaulista.api.service;

import com.jovempaulista.api.model.Jovem;
import com.jovempaulista.api.model.Usuario;
import com.jovempaulista.api.repository.JovemRepository;
import com.jovempaulista.api.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JovemService {

    @Autowired
    private JovemRepository repository;

    @Autowired
    private usuarioRepository usuarioRepository;

    public List<Jovem> listarTodos() {
        return repository.findAll();
    }

    public Jovem buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jovem não encontrado"));
    }

    public Jovem salvar(Jovem jovem) {
        if (jovem.getUsuario() != null && jovem.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(jovem.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            jovem.setUsuario(usuario);
        }
        return repository.save(jovem);
    }

    public Jovem atualizar(Long id, Jovem dados) {
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