package com.purplegym.purplegymweb.domain.teste;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Table(name = "teste")
@Entity(name = "teste")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String teste;

    public Teste(TesteRequestDTO data) {
        this.teste = data.teste();
    }
}
