package com.springframework.bjornpetclinic.repositories;

import com.springframework.bjornpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
