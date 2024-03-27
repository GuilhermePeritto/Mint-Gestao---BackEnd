package com.purplegym.purplegymweb.Repositories;


import com.purplegym.purplegymweb.domain.usuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {

    UserDetails findByEmail(String email);
}
