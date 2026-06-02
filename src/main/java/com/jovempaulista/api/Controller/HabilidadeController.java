package com.jovempaulista.api.Controller;

import com.jovempaulista.api.model.Habilidade;
import com.jovempaulista.api.service.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService service;

    @GetMapping
    public List<Habilidade> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Habilidade buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Habilidade criar(@RequestBody Habilidade habilidade) {
        return service.salvar(habilidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}