package com.springframework.bjornpetclinic.services;

import com.springframework.bjornpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
