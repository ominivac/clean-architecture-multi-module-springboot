package br.com.elwgomes.animal.entities;

import br.com.elwgomes.animal.domain.Specie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_animals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specie specie;
}
