package io.swagger.api;

import io.swagger.model.Projecte;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-26T14:49:25.168Z")

@Controller
public class ProjecteApiController implements ProjecteApi {

    private static final Logger log = LoggerFactory.getLogger(ProjecteApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProjecteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addProjecte(@ApiParam(value = "Instancia de projecte afegit"  )  @Valid @RequestBody Projecte objecteProjecte) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Projecte>> findProjecte(@NotNull @ApiParam(value = "Filtrar per nom", required = true) @Valid @RequestParam(value = "nom", required = true) String nom) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Projecte>>(objectMapper.readValue("[ {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Projecte>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Projecte>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Projecte> getProjecteById(@ApiParam(value = "ID del projecte a retornar",required=true) @PathVariable("idProjecte") Integer idProjecte) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Projecte>(objectMapper.readValue("{  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}", Projecte.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Projecte>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Projecte>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Projecte>> getProjectes() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Projecte>>(objectMapper.readValue("[ {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"color\" : \"#42f4ce\",  \"descripcio\" : \"Projecte Balearia\",  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"idProjecte\" : 11,  \"nom\" : \"Balearia\",  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Projecte>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Projecte>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateProjecte(@ApiParam(value = "Objecte projecte que sha de modificar" ,required=true )  @Valid @RequestBody Projecte body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
