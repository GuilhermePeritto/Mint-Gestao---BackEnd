package com.purplegym.purplegymweb.domain.usuarios;

public record AuthenticationExternalDTO(String nome, String email, String senha, Origem origem, UserRole role) {
}
