package br.com.elwgomes.animal.adapters;

import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.domain.Specie;
import br.com.elwgomes.animal.entities.AnimalEntity;
import br.com.elwgomes.animal.exceptions.CustomException;
import br.com.elwgomes.animal.repositories.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AnimalDatabaseAdapterCreateTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalDatabaseAdapter animalDatabaseAdapter;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate_Successful() throws CustomException {
        // given
//        AnimalDomain animalDomain = new AnimalDomain(null, "Tacco", Specie.DOG);
        AnimalDomain animalDomain = AnimalDomain.builder()
                .name("Tacco")
                .specie(Specie.DOG)
                .build();
        when(animalRepository.save(any())).thenReturn(new AnimalEntity(null, "Tacco", Specie.DOG));
        // when
        animalDatabaseAdapter.create(animalDomain);
        // then
        verify(animalRepository, times(1)).save(any());
    }

    @Test
    public void testCreate_WithEmptyName() {
        // given
        AnimalDomain animalDomain = AnimalDomain.builder()
                .name("")
                .specie(Specie.DOG)
                .build();
        // when & then
        CustomException exception = assertThrows(CustomException.class, () -> {
            animalDatabaseAdapter.create(animalDomain);
        });
        assertEquals("Something goes wrong with name field. Please check over.", exception.getMessage());
        verify(animalRepository, never()).save(any());
    }

    @Test
    public void testCreate_WithNullName() {
        // given
        AnimalDomain animalDomain = AnimalDomain.builder()
                .name(null)
                .specie(Specie.DOG)
                .build();

        // when & then
        CustomException exception = assertThrows(CustomException.class, () -> {
            animalDatabaseAdapter.create(animalDomain);
        });
        assertEquals("Something goes wrong with name field. Please check over.", exception.getMessage());
        verify(animalRepository, never()).save(any());
    }

    @Test
    public void testCreate_RepositoryThrowsException() throws CustomException {
        // given
        AnimalDomain animalDomain = AnimalDomain.builder().name("Lion").build();
        when(animalRepository.save(any())).thenThrow(new RuntimeException("Repository failed"));
        // when & then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            animalDatabaseAdapter.create(animalDomain);
        });
        assertEquals("Repository failed", exception.getMessage());
        verify(animalRepository, times(1)).save(any());
    }

}
