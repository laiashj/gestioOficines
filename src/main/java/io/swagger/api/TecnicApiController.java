package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Tecnic;

@RestController
public class TecnicApiController {

    @Autowired
    private TecnicApi tecnicRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/tecnics")
    public Iterable<Tecnic> tecnic() {
        return tecnicRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tecnics")
    public Tecnic save(@RequestBody Tecnic tecnic) {
        tecnicRepository.save(tecnic);
        return tecnic;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tecnics/{id}")
    public Tecnic show(@PathVariable String id) {
        return tecnicRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tecnics/{id}")
    public Tecnic update(@PathVariable String id, @RequestBody Tecnic tecnic) {
        Tecnic t = tecnicRepository.findOne(id);
        if (tecnic.getNomCognom() != null) {
            t.setNomCognom(tecnic.getNomCognom());
        }
        if (tecnic.getEstat() != null) {
            t.setEstat(tecnic.getEstat());
        }
        if (tecnic.getDataAlta() != null) {
            t.setDataAlta(tecnic.getDataAlta());
        }
        tecnicRepository.save(t);
        return tecnic;
    }
    /*
     * public ResponseEntity<Boolean> addTecnic(@ApiParam(value =
     * "Instancia de tecnic afegit" ) @Valid @RequestBody Tecnic objecteTecnic)
     * { String accept = request.getHeader("Accept");
     * tecnicRepository.addTecnic(objecteTecnic); return new
     * ResponseEntity<>(true,HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<List<Tecnic>> findTecnic(@NotNull @ApiParam(value =
     * "Filtrar per nom", required = true) @Valid @RequestParam(value = "nom",
     * required = true) String nom) { String accept =
     * request.getHeader("Accept"); if (accept != null &&
     * accept.contains("application/json")) { try { return new
     * ResponseEntity<List<Tecnic>>(serveiTecnics.getTecnicsByNom(nom),
     * objectMapper.readValue(
     * "[ {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]"
     * , List.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<List<Tecnic>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new ResponseEntity<List<Tecnic>>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<List<Tecnic>>
     * findTecnicByStatus(@NotNull @ApiParam(value = "estats filtrats", required
     * = true) @Valid @RequestParam(value = "status", required = true) String
     * status) { String accept = request.getHeader("Accept"); if (accept != null
     * && accept.contains("application/json")) { try { return new
     * ResponseEntity<List<Tecnic>>(objectMapper.readValue(
     * "[ {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]"
     * , List.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<List<Tecnic>>(tecnicRepository.getTecnicsByStatus(status),
     * HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new ResponseEntity<List<Tecnic>>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<Tecnic> getTecnicById(@ApiParam(value =
     * "ID del tecnic a retornar",required=true) @PathVariable("idTecnic")
     * Integer idTecnic) { String accept = request.getHeader("Accept"); if
     * (accept != null && accept.contains("application/json")) { try { return
     * new ResponseEntity<Tecnic>(objectMapper.readValue(
     * "{  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}"
     * , Tecnic.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<Tecnic>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new
     * ResponseEntity<Tecnic>(tecnicRepository.getTecnic(idTecnic),HttpStatus.
     * NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<List<Tecnic>> getTecnics() { String accept =
     * request.getHeader("Accept"); if (accept != null &&
     * accept.contains("application/json")) { try { return new
     * ResponseEntity<List<Tecnic>>(objectMapper.readValue(
     * "[ {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"projecte\" : {    \"color\" : \"#42f4ce\",    \"descripcio\" : \"Projecte Balearia\",    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"idProjecte\" : 11,    \"nom\" : \"Balearia\",    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"lloc\" : {    \"habilitat\" : true,    \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",    \"toma\" : 92,    \"idLloc\" : 222,    \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"  },  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"estat\" : \"noAssignat\",  \"idTecnic\" : 600985,  \"nomCognom\" : \"Ramona Flowers\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]"
     * , List.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<List<Tecnic>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new
     * ResponseEntity<List<Tecnic>>(tecnicRepository.getTecnics(),HttpStatus.
     * NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<Boolean> updateTecnic(@ApiParam(value =
     * "Objecte Tecnic que sha de modificar" ,required=true
     * )@PathVariable("index") int index, @Valid @RequestBody Tecnic body) {
     * String accept = request.getHeader("Accept");
     * serveiTecnics.updateTecnic(index, body); return new
     * ResponseEntity<>(true,HttpStatus.NOT_IMPLEMENTED); }
     */

}
