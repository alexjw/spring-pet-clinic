package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository, Long> implements OwnerService {

    @Autowired
    public OwnerJpaService(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

}
