package com.jovempaulista.api.controller;

import com.jovempaulista.api.model.Vaga;
import com.jovempaulista.api.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService service;

    @GetMapping
    public List<Vaga> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/ativas")
    public List<Vaga> listarAtivas() {
        return service.listarAtivas();
    }

    @GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        return service.salvar(vaga);
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vaga) {
        return service.atualizar(id, vaga);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}