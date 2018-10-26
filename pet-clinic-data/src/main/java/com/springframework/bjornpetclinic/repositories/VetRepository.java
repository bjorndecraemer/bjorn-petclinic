package com.springframework.bjornpetclinic.repositories;

import com.springframework.bjornpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
