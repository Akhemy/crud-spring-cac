package com.api.crud_spring_cac.controllers;

import com.api.crud_spring_cac.models.UsuarioModel;
import com.api.crud_spring_cac.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> getUsuarios() {
        return this.usuarioService.getUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUsersById(@PathVariable("id")Long id){
        return this.UsuarioService.getById(id);
    }

    @PutMapping(path ="/{id}")
    public UsuarioModel updateUserById (@RequestBody UsuarioModel request, @PathVariable("id") Long id){
        return this.UsuarioService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String UsuarioModel deleteById(@PathVariable("id") Long id)
        boolean ok = this.UsuarioService.deleteUsuario(id);

        if(ok){
            return "Usuario with id" + id + " deleted!";  
        }else{
            return "Error, tenemos un problema y no podemos eliminar el usuario con ID "
        }
    }
}
