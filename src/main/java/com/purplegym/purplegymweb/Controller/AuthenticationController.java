package com.purplegym.purplegymweb.Controller;

import com.purplegym.purplegymweb.domain.usuarios.*;
import com.purplegym.purplegymweb.Repositories.UsuariosRepository;
import com.purplegym.purplegymweb.infra.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((Usuarios) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (AuthenticationException e) {
            // Aqui você pode tratar a exceção e retornar uma resposta personalizada
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/loginexterno")
    public ResponseEntity loginExterno(@RequestBody @Valid AuthenticationExternalDTO data) {
        try {
            if (this.repository.findByEmail(data.email()) == null) {
                String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
                var user = new Usuarios(data.email(), encryptedPassword, data.origem(), data.nome(), data.role());
                repository.save(user);
            }

            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((Usuarios) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (AuthenticationException e) {
            // Aqui você pode tratar a exceção e retornar uma resposta personalizada
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        var user = new Usuarios(data.email(), encryptedPassword ,data.origem(), data.nome(), data.role());

        repository.save(user);

        return ResponseEntity.ok().build();
    }
}
