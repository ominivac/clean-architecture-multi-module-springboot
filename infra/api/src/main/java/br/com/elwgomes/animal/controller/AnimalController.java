package br.com.elwgomes.animal.controller;

import br.com.elwgomes.animal.controller.response.AnimalControllerResponse;
import br.com.elwgomes.animal.domain.AnimalDomain;
import br.com.elwgomes.animal.entities.AnimalEntity;
import br.com.elwgomes.animal.exceptions.CustomException;
import br.com.elwgomes.animal.mapper.AnimalHttpMapper;
import br.com.elwgomes.animal.ports.contract.CreateAnimalCommand;
import br.com.elwgomes.animal.ports.contract.GetAllAnimalsCommand;
import br.com.elwgomes.animal.request.AnimalRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/animal")
@RequiredArgsConstructor
public class AnimalController {
    private final CreateAnimalCommand createAnimalCommand;
    private final GetAllAnimalsCommand getAllAnimalsCommand;
    @PostMapping
    public AnimalControllerResponse create (@RequestBody AnimalRequest request) throws CustomException {
        createAnimalCommand.execute(AnimalHttpMapper.INSTANCE.toDomain(request));
        return new AnimalControllerResponse<>("created", String.valueOf(HttpStatus.CREATED.value()), "Animal has been created.");
    }
    @GetMapping
    public AnimalControllerResponse<List<AnimalRequest>> getAll() {
        List<AnimalDomain> animalDomains = getAllAnimalsCommand.execute();
        List<AnimalRequest> animalRequests = new ArrayList<>();
        for (AnimalDomain animalDomain : animalDomains) {
            animalRequests.add(AnimalHttpMapper.INSTANCE.toRequest(animalDomain));
        }
        return new AnimalControllerResponse<>("success", String.valueOf(HttpStatus.OK.value()), animalRequests);
    }
}
