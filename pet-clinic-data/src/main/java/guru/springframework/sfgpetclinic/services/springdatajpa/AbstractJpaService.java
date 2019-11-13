package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity, R extends CrudRepository<T, ID>, ID extends Long> implements CrudService<T, ID> {

    R r;

    public AbstractJpaService(R r) {
        this.r = r;
        System.out.println("JPA Service was called");
    }

    @Override
    public Set<T> findAll() {
        Set<T> ts = new HashSet<>();
        r.findAll().forEach(ts::add);
        return ts;
    }

    @Override
    public T findById(ID id) {
        return r.findById(id).orElse(null);
    }

    @Override
    public T save(T object) {
        return r.save(object);
    }

    @Override
    public void delete(T object) {
        r.delete(object);
    }

    @Override
    public void deleteById(ID id) {
        r.deleteById(id);
    }
}
