/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Tecnic;


import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface TecnicApi extends CrudRepository<Tecnic,String>, CustomRepository {
    @Override
    Tecnic findOne(String idTecnic);
   
}
