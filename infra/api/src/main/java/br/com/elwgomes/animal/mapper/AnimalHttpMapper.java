package br.com.elwgomes.animal.mapper;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.request.AnimalRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimalHttpMapper {
    AnimalHttpMapper INSTANCE = Mappers.getMapper(AnimalHttpMapper.class);
    AnimalDomain toDomain(AnimalRequest request);
    AnimalRequest toRequest(AnimalDomain domain);
}
