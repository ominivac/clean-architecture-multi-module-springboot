package br.com.elwgomes.animal.adapters;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.mapper.AnimalMapper;
import br.com.elwgomes.animal.ports.spi.AnimalDatabasePort;
import br.com.elwgomes.animal.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Primary
@RequiredArgsConstructor
public class AnimalDatabaseAdapter implements AnimalDatabasePort {
    private final AnimalRepository animalRepository;
    @Override
    public void create(AnimalDomain animalDomain) {
        AnimalMapper.INSTANCE.toDomain(
                animalRepository.save(AnimalMapper.INSTANCE.toEntity(animalDomain)));
    }
}
