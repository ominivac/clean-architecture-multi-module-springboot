package br.com.elwgomes.animal.ports.spi;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.exceptions.CustomException;

import java.util.List;

public interface AnimalDatabasePort {
    void create(AnimalDomain animalDomain) throws CustomException;
    List<AnimalDomain> getAllAnimals();
}
