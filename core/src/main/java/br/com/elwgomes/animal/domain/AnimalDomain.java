package br.com.elwgomes.animal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDomain {
    private UUID id;
    private String name;
    private Specie specie;
}
