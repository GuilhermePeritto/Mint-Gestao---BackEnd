package com.purplegym.purplegymweb.domain.usuarios;

public record UsuariosRequestDTO(String nome, String email, String senha, UserRole role) {
}
