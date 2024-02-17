package br.com.elwgomes.animal.usecases;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import br.com.elwgomes.animal.ports.contract.CreateAnimalCommand;
import br.com.elwgomes.animal.ports.spi.AnimalDatabasePort;
@RequiredArgsConstructor
public class CreateAnimalHandler implements CreateAnimalCommand {
    private final AnimalDatabasePort animalDatabasePort;
    @Override
    public void execute(AnimalDomain animalDomain) throws CustomException {
        animalDatabasePort.create(animalDomain);
    }
}
