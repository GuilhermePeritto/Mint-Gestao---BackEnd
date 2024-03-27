package com.purplegym.purplegymweb.Controller;

import com.purplegym.purplegymweb.domain.usuarios.UsuariosRequestDTO;
import com.purplegym.purplegymweb.domain.usuarios.UsuariosResponseDTO;
import com.purplegym.purplegymweb.domain.usuarios.Usuarios;
import com.purplegym.purplegymweb.Repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("usuarios")
@CrossOrigin("*")
public class UsuariosController {
    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public List<UsuariosResponseDTO> getAll(){

        return repository.findAll().stream().map(UsuariosResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public UsuariosResponseDTO getById(@PathVariable UUID id) {

        return repository.findById(id).stream().map(UsuariosResponseDTO::new).findFirst().orElse(null);
    }

    @PostMapping
    public void create(@RequestBody UsuariosRequestDTO data) {
        Usuarios usuariosData = new Usuarios(data);
        repository.save(usuariosData);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody UsuariosRequestDTO data) {

        Usuarios usuarioData = new Usuarios(data);
        usuarioData.setId(id);
        repository.save(usuarioData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {

        repository.deleteById(id);
    }

}
