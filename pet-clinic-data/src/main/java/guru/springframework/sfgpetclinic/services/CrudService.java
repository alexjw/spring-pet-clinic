package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity, ID> {

    public Set<T> findAll();

    public T findById(ID id);

    public T save(T object);

    public void delete(T object);

    public void deleteById(ID id);

}
