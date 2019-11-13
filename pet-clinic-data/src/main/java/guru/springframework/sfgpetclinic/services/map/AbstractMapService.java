package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.context.annotation.Profile;

import java.util.*;

// Done Better than the course
@Profile({"default", "map"})
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    public AbstractMapService() {
        System.out.println("Map Service was called");
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if(object == null)
            return null;
        if(object.getId() == null)
            object.setId(getNextId());
        return save((ID)object.getId(), object);
    }

    public T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if(map.isEmpty())
            return 1L;
        return ((Long)Collections.max(map.keySet())) + 1;
    }

}