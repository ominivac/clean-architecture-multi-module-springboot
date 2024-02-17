package br.com.elwgomes.animal.ports.contract;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.exceptions.CustomException;

public interface CreateAnimalCommand {
    void execute(AnimalDomain animalDomain) throws CustomException;
}
