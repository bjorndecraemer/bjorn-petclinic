package com.springframework.bjornpetclinic.services;

import com.springframework.bjornpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
