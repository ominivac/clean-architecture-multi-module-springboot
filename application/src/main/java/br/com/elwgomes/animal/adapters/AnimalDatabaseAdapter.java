package br.com.elwgomes.animal.adapters;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.entities.AnimalEntity;
import br.com.elwgomes.animal.exceptions.CustomException;
import br.com.elwgomes.animal.mapper.AnimalMapper;
import br.com.elwgomes.animal.ports.spi.AnimalDatabasePort;
import br.com.elwgomes.animal.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component @Primary
@RequiredArgsConstructor
public class AnimalDatabaseAdapter implements AnimalDatabasePort {
    private final AnimalRepository animalRepository;
    @Override
    public void create(AnimalDomain animalDomain) throws CustomException {
        if (animalDomain.getName() == null || animalDomain.getName().isEmpty()) {
            throw new CustomException("Something goes wrong with name field. Please check over.");
        }
        AnimalMapper.INSTANCE.toDomain(
                animalRepository.save(AnimalMapper.INSTANCE.toEntity(animalDomain)));
    }

    @Override
    public List<AnimalDomain> getAllAnimals() {
        List<AnimalEntity> animalEntities = animalRepository.findAll();
        return AnimalMapper.INSTANCE.listToDomain(animalEntities);
    }
}
