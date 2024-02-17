package br.com.elwgomes.animal.request;

import br.com.elwgomes.animal.domain.Specie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalRequest implements Serializable {
    private String name;
    private Specie specie;
}
