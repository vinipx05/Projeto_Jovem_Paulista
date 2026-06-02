package com.jovempaulista.api.Controller;

import com.jovempaulista.api.model.Empresa;
import com.jovempaulista.api.service.EmpresaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public List<Empresa> listarTodas(){
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);

    }

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa){
        return service.salvar(empresa);

    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresa){
        return service.atualizar(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
