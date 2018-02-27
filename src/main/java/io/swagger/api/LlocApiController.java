package io.swagger.api;

import io.swagger.model.Lloc;
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
public class LlocApiController implements LlocApi {

    private static final Logger log = LoggerFactory.getLogger(LlocApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LlocApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addLloc(@ApiParam(value = "Instancia de lloc afegit"  )  @Valid @RequestBody Lloc objecteLloc) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Lloc> getLlocById(@ApiParam(value = "ID del lloc a retornar",required=true) @PathVariable("idLloc") Integer idLloc) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Lloc>(objectMapper.readValue("{  \"habilitat\" : true,  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"toma\" : 92,  \"idLloc\" : 222,  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}", Lloc.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Lloc>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Lloc>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Lloc>> getLlocs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Lloc>>(objectMapper.readValue("[ {  \"habilitat\" : true,  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"toma\" : 92,  \"idLloc\" : 222,  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"}, {  \"habilitat\" : true,  \"dataAlta\" : \"2016-08-29T09:12:33.001Z\",  \"toma\" : 92,  \"idLloc\" : 222,  \"dataBaixa\" : \"2016-08-29T09:12:33.001Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Lloc>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Lloc>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateLloc(@ApiParam(value = "Objecte Lloc que sha de modificar" ,required=true )  @Valid @RequestBody Lloc body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
