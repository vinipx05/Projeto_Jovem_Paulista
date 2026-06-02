package com.jovempaulista.api.Controller;

import com.jovempaulista.api.model.Usuario;
import com.jovempaulista.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService Service;

    @GetMapping("/{id}")
    public List<Usuario> listarTodos(){
        return Service.listarTodos();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){
        return Service.salvar(usuario);
    }

    @PutMapping("/{id}")
        public Usuario atualizar(@PathVariable long id, @RequestBody Usuario usuario){
        return Service.atualizar(id, usuario);
        }

        @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        Service.deletar(id);
        }
}
