package com.jovempaulista.api.Controller;

import com.jovempaulista.api.model.Candidatura;
import com.jovempaulista.api.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService service;

    @GetMapping
    public List<Candidatura> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/jovem/{jovemId}")
    public List<Candidatura> listarPorJovem(@PathVariable Long jovemId) {
        return service.listarPorJovem(jovemId);
    }

    @GetMapping("/vaga/{vagaId}")
    public List<Candidatura> listarPorVaga(@PathVariable Long vagaId) {
        return service.listarPorVaga(vagaId);
    }

    @GetMapping("/{id}")
    public Candidatura buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Candidatura criar(@RequestBody Candidatura candidatura) {
        return service.salvar(candidatura);
    }

    @PatchMapping("/{id}/status")
    public Candidatura atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}