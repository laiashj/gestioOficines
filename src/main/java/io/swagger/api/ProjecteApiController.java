package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.model.Projecte;

@Controller
public class ProjecteApiController {

    @Autowired
    private ProjecteApi projecteRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/projectes")
    public Iterable<Projecte> projecte() {
        return projecteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/projectes")
    public Projecte save(@RequestBody Projecte projecte) {
        projecteRepository.save(projecte);
        return projecte;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/{id}")
    public Projecte show(@PathVariable String id) {
        return projecteRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/projectes/{id}")
    public Projecte update(@PathVariable String id, @RequestBody Projecte projecte) {
        Projecte p = projecteRepository.findOne(id);
        if (projecte.getNom() != null) {
            p.setNom(projecte.getNom());
        }
        if (projecte.getDescripcio() != null) {
            p.setDescripcio(projecte.getDescripcio());
        }
        if (projecte.getDataAlta() != null) {
            p.setColor(projecte.getColor());
        }
        if (projecte.getDataAlta() != null) {
            p.setDataAlta(projecte.getDataAlta());
        }
        if (projecte.getDataBaixa() != null) {
            p.setDataBaixa(projecte.getDataBaixa());
        }
        projecteRepository.save(p);
        return projecte;
    }

    /*
     * @org.springframework.beans.factory.annotation.Autowired public
     * ProjecteApiController(ObjectMapper objectMapper, HttpServletRequest
     * request) { this.objectMapper = objectMapper; this.request = request; }
     * 
     * public ResponseEntity<Void> addProjecte(
     * 
     * @ApiParam(value = "Instancia de projecte afegit") @Valid @RequestBody
     * Projecte objecteProjecte) { String accept = request.getHeader("Accept");
     * return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<List<Projecte>> findProjecte(
     * 
     * @NotNull @ApiParam(value = "Filtrar per nom", required =
     * true) @Valid @RequestParam(value = "nom", required = true) String nom) {
     * String accept = request.getHeader("Accept"); if (accept != null &&
     * accept.contains("application/json")) { try { return new
     * ResponseEntity<List<Projecte>>(objectMapper.readValue(
     * "[ {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]"
     * , List.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<List<Projecte>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new ResponseEntity<List<Projecte>>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<Projecte> getProjecteById(
     * 
     * @ApiParam(value = "ID del projecte a retornar", required =
     * true) @PathVariable("idProjecte") Integer idProjecte) { String accept =
     * request.getHeader("Accept"); if (accept != null &&
     * accept.contains("application/json")) { try { return new
     * ResponseEntity<Projecte>(objectMapper.readValue(
     * "{  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}"
     * , Projecte.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<Projecte>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new ResponseEntity<Projecte>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<List<Projecte>> getProjectes() { String accept =
     * request.getHeader("Accept"); if (accept != null &&
     * accept.contains("application/json")) { try { return new
     * ResponseEntity<List<Projecte>>(objectMapper.readValue(
     * "[ {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]"
     * , List.class), HttpStatus.NOT_IMPLEMENTED); } catch (IOException e) {
     * log.error("Couldn't serialize response for content type application/json"
     * , e); return new
     * ResponseEntity<List<Projecte>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     * 
     * return new ResponseEntity<List<Projecte>>(HttpStatus.NOT_IMPLEMENTED); }
     * 
     * public ResponseEntity<Void> updateProjecte(
     * 
     * @ApiParam(value = "Objecte projecte que sha de modificar", required =
     * true) @Valid @RequestBody Projecte body) { String accept =
     * request.getHeader("Accept"); return new
     * ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED); }
     */

}
