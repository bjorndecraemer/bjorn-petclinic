package com.springframework.bjornpetclinic.repositories;

import com.springframework.bjornpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
