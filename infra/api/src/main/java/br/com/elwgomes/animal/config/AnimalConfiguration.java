package br.com.elwgomes.animal.config;

import br.com.elwgomes.animal.ports.contract.CreateAnimalCommand;
import br.com.elwgomes.animal.ports.contract.GetAllAnimalsCommand;
import br.com.elwgomes.animal.ports.spi.AnimalDatabasePort;
import br.com.elwgomes.animal.repositories.AnimalRepository;
import br.com.elwgomes.animal.usecases.CreateAnimalHandler;
import br.com.elwgomes.animal.usecases.GetAllAnimalsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AnimalConfiguration {

    private final AnimalDatabasePort animalDatabasePort;

    @Bean
    public CreateAnimalCommand createAnimalCommand() {
        return new CreateAnimalHandler(animalDatabasePort);
    }

    @Bean
    public GetAllAnimalsCommand createGetAllAnimalsCommand() {
        return new GetAllAnimalsHandler(animalDatabasePort);
    }

}
