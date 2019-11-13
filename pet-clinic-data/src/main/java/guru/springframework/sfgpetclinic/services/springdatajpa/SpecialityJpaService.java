package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialityJpaService extends AbstractJpaService<Speciality, SpecialityRepository, Long> implements SpecialityService {

    public SpecialityJpaService(SpecialityRepository specialityRepository) {
        super(specialityRepository);
    }

}
