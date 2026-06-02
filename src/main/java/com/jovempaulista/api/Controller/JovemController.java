package com.jovempaulista.api.Controller;

import com.jovempaulista.api.model.Jovem;
import com.jovempaulista.api.service.JovemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/jovens")
public class JovemController {

    @Autowired
    private JovemService service;

    @GetMapping
    public List<Jovem> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Jovem buscar(@PathVariable long id){
        return service.buscarPorId(id);

    }

    @PostMapping
    public Jovem criar(@RequestBody Jovem jovem){
        return service.salvar(jovem);
    }

    @PutMapping("/{id}")
    public Jovem atualizar(@PathVariable long id, @RequestBody Jovem jovem){
        return service.atualizar(id, jovem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        service.deletar(id);
    }
}
