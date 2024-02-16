package br.com.elwgomes.animal.repositories;

import br.com.elwgomes.animal.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<AnimalEntity, UUID> {
}
