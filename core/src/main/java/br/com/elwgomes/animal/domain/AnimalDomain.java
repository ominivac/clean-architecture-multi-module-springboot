package br.com.elwgomes.animal.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDomain {
    private UUID id;
    private String name;
    private Specie specie;
}
