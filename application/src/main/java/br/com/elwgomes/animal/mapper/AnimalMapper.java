package br.com.elwgomes.animal.mapper;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.entities.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
    AnimalDomain toDomain(AnimalEntity entity);
    AnimalEntity toEntity(AnimalDomain domain);
}
