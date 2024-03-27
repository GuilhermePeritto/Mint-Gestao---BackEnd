package com.purplegym.purplegymweb.Controller;

import com.purplegym.purplegymweb.domain.teste.TesteRequestDTO;
import com.purplegym.purplegymweb.domain.teste.TesteResponseDTO;
import com.purplegym.purplegymweb.domain.teste.Teste;
import com.purplegym.purplegymweb.Repositories.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("teste")
@CrossOrigin("*")
public class TesteController {

    @Autowired
    private TesteRepository repository;

    @GetMapping
    public List<TesteResponseDTO> getAll(){

        return repository.findAll().stream().map(TesteResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public TesteResponseDTO getById(@PathVariable UUID id) {

        return repository.findById(id).stream().map(TesteResponseDTO::new).findFirst().orElse(null);
    }

    @PostMapping
    public void create(@RequestBody TesteRequestDTO data) {
        Teste testeData = new Teste(data);
        repository.save(testeData);
        return;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody TesteRequestDTO data) {

        Teste testeData = new Teste(data);
        testeData.setId(id);
        repository.save(testeData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {

        repository.deleteById(id);
    }

}
