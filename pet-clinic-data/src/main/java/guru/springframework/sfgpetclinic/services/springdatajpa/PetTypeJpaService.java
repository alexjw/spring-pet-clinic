package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository, Long> implements PetTypeService {

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }
}
