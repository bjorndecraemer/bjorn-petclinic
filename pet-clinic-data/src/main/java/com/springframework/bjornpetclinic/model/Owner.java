package com.springframework.bjornpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String city, String telephone) {
        super(id, firstName, lastName);
        if(pets != null) {
            this.pets = pets;
        }
        else{
            this.pets = new HashSet<>();
        }
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<Pet>();
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    public Pet getPet(String name){
        return getPet(name,false);
    }

    public Pet getPet(String name, boolean ignoreNew){
        for (Pet pet : pets) {
            if(!ignoreNew || !pet.isNew()){
                if(pet.getName().equalsIgnoreCase(name)){
                    return pet;
                }
            }
        }
        return null;
    }
}
