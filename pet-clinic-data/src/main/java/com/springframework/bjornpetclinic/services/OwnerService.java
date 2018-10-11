package com.springframework.bjornpetclinic.services;

import com.springframework.bjornpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);
}
