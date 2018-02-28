package io.swagger.dto;

import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Tecnic;

public interface TecnicDTO extends CrudRepository<Tecnic, String>{

    @Override
    Tecnic findOne(String id);

}
