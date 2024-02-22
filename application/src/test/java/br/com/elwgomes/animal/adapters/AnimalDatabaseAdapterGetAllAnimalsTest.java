package br.com.elwgomes.animal.adapters;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.domain.Specie;
import br.com.elwgomes.animal.entities.AnimalEntity;
import br.com.elwgomes.animal.repositories.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnimalDatabaseAdapterGetAllAnimalsTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalDatabaseAdapter animalDatabaseAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAnimals_EmptyList() {
        // given
        when(animalRepository.findAll()).thenReturn(Collections.emptyList());
        // when
        List<AnimalDomain> result = animalDatabaseAdapter.getAllAnimals();
        // then
        verify(animalRepository, times(1)).findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllAnimals_RepositoryThrowsException() {
        // given
        when(animalRepository.findAll()).thenThrow(new RuntimeException("Repository failed"));
        // when & then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            animalDatabaseAdapter.getAllAnimals();
        });
        assertEquals("Repository failed", exception.getMessage());
        verify(animalRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllAnimals_NullResultFromRepository() {
        // given
        when(animalRepository.findAll()).thenReturn(null);
        // when
        List<AnimalDomain> result = animalDatabaseAdapter.getAllAnimals();
        // then
        verify(animalRepository, times(1)).findAll();
        assertNull(result);
    }

    @Test
    public void testGetAllAnimals_Successful() {
        // given
        List<AnimalEntity> animalEntities = Arrays.asList(
                AnimalEntity.builder().name("Tacco").specie(Specie.HORSE).build(),
                AnimalEntity.builder().name("Flocos").specie(Specie.CAT).build()
        );
        when(animalRepository.findAll()).thenReturn(animalEntities);

        // when
        List<AnimalDomain> result = animalDatabaseAdapter.getAllAnimals();

        // then
        verify(animalRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals("Tacco", result.get(0).getName());
        assertEquals("Flocos", result.get(1).getName());
    }
}


