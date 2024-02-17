package br.com.elwgomes.animal.usecases;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.ports.contract.GetAllAnimalsCommand;
import br.com.elwgomes.animal.ports.spi.AnimalDatabasePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllAnimalsHandler implements GetAllAnimalsCommand {
    private final AnimalDatabasePort animalDatabasePort;
    @Override
    public List<AnimalDomain> execute() {
        return animalDatabasePort.getAllAnimals();
    }
}
