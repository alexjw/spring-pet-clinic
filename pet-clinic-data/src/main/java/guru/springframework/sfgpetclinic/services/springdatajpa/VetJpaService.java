package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetJpaService extends AbstractJpaService<Vet, VetRepository, Long> implements VetService {

    public VetJpaService(VetRepository vetRepository) {
        super(vetRepository);
    }

}
