package br.com.elwgomes.animal.ports.contract;

import br.com.elwgomes.animal.domain.AnimalDomain;

public interface CreateAnimalCommand {
    void execute(AnimalDomain animalDomain);
}
