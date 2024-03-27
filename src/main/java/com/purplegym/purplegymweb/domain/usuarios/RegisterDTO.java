package com.purplegym.purplegymweb.domain.usuarios;

public record RegisterDTO(String nome, String email, String senha, UserRole role, Origem origem) {
}
