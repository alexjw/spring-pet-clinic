package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Pet Types
        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);
        PetType parrot = new PetType();
        parrot.setName("parrot");
        petTypeService.save(parrot);

        System.out.println("Loaded Pet Types....");

        Pet pet = new Pet();
        pet.setPetType(dog);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Dipsi");

        Pet pet1 = new Pet();
        pet1.setPetType(parrot);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Coco");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Street");
        owner1.setCity("Miami");
        owner1.setPhone("0985123456");
        owner1.getPets().add(pet);

        ownerService.save(owner1);
        pet.setOwner(owner1);
        petService.save(pet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("345 Street");
        owner2.setCity("San Francisco");
        owner2.setPhone("0985654321");
        owner1.getPets().add(pet1);

        ownerService.save(owner2);
        pet1.setOwner(owner2);
        petService.save(pet1);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }

}