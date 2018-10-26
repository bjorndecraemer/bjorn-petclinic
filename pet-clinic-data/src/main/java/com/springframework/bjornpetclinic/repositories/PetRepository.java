package com.springframework.bjornpetclinic.repositories;

import com.springframework.bjornpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
