package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.PetService;

public class PetJpaService extends AbstractJpaService<Pet, PetRepository, Long> implements PetService {

    public PetJpaService(PetRepository petRepository) {
        super(petRepository);
    }

}
