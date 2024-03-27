package com.purplegym.purplegymweb.domain.teste;

import com.purplegym.purplegymweb.domain.teste.Teste;
import java.util.UUID;

public record TesteResponseDTO(UUID id, String teste) {

    public TesteResponseDTO(Teste teste){
        this(teste.getId(), teste.getTeste());
    }
}
