package com.purplegym.purplegymweb.Repositories;

import com.purplegym.purplegymweb.domain.teste.Teste;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TesteRepository extends JpaRepository<Teste, UUID> {
}
