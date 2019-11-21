package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    private Long ownerId;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap();
        Owner owner = new Owner();
        owner.setId(1000l);
        Owner owner2 = new Owner();
        owner2.setId(1001l);
        ownerServiceMap.save(owner);
        ownerServiceMap.save(owner2);
        ownerId = owner.getId();
    }

    @Test
    void save() {
        int size = ownerServiceMap.findAll().size();
        Owner owner = new Owner();
        ownerServiceMap.save(owner);
        assertNotNull(owner);
        assertNotNull(owner.getId());
        assertEquals(size + 1, ownerServiceMap.findAll().size());
    }

    @Test
    void findAll() {
        assertNotEquals(0, ownerServiceMap.findAll().size()); ;
    }

    @Test
    void findById() {
        assertEquals(ownerId, ownerServiceMap.findById(ownerId).getId());
    }

    @Test
    void deleteById() {
        int size = ownerServiceMap.findAll().size();
        ownerServiceMap.deleteById(ownerServiceMap.findById(ownerId + 1).getId());
        assertEquals(size - 1, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        int size = ownerServiceMap.findAll().size();
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(size - 1, ownerServiceMap.findAll().size());
    }
}