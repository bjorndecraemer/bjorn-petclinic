package com.springframework.bjornpetclinic.bootstrap;

import com.springframework.bjornpetclinic.model.Owner;
import com.springframework.bjornpetclinic.model.Pet;
import com.springframework.bjornpetclinic.model.PetType;
import com.springframework.bjornpetclinic.model.Vet;
import com.springframework.bjornpetclinic.services.OwnerService;
import com.springframework.bjornpetclinic.services.PetTypeService;
import com.springframework.bjornpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Kapelstraat 123");
        owner1.setCity("Schorisse");
        owner1.setTelephone("123456787");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Max");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Kerkstraat 456");
        owner2.setCity("Ronse");
        owner2.setTelephone("98765432");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Pixel");
        owner2.getPets().add(fionasPet);


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
