package com.springframework.bjornpetclinic.bootstrap;

import com.springframework.bjornpetclinic.model.Owner;
import com.springframework.bjornpetclinic.model.PetType;
import com.springframework.bjornpetclinic.model.Vet;
import com.springframework.bjornpetclinic.services.OwnerService;
import com.springframework.bjornpetclinic.services.PetTypeService;
import com.springframework.bjornpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Celien");
        vet2.setLastName("Vannieuwenhove");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");




    }
}
