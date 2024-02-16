package br.com.elwgomes.animal.ports.spi;

import br.com.elwgomes.animal.domain.AnimalDomain;

public interface AnimalDatabasePort {
    void create(AnimalDomain animalDomain);
}
