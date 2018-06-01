package io.swagger.api;

import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Projecte;

public interface ProjecteApi extends CrudRepository<Projecte, String>, CustomRepositoryProjecte {
    @Override
    Projecte findOne(String idProjecte);
}