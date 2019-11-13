package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository, Long> implements VisitService {

    public VisitJpaService(VisitRepository visitRepository) {
        super(visitRepository);
    }

}
