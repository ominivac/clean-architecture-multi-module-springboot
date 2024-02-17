package br.com.elwgomes.animal.ports.contract;

import br.com.elwgomes.animal.domain.AnimalDomain;

import java.util.List;

public interface GetAllAnimalsCommand {
    List<AnimalDomain> execute();
}
