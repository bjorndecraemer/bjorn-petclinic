package com.springframework.bjornpetclinic.repositories;

import com.springframework.bjornpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
