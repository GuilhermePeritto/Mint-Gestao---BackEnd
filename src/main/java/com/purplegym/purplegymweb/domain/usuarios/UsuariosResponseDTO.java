package com.purplegym.purplegymweb.domain.usuarios;

import java.util.UUID;

public record UsuariosResponseDTO(UUID id, String nome, String email, String senha, UserRole role) {

    public UsuariosResponseDTO(Usuarios usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getRole());
    }
}
