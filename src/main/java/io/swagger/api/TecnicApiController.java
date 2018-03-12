package io.swagger.api;

import io.swagger.model.Tecnic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TecnicApiController {

    @Autowired
    private TecnicApi tecnicRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/tecnics")
    public Iterable<Tecnic> tecnic() {
	return tecnicRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tecnics")
    public Tecnic saveTecnic(@RequestBody Tecnic tecnic) {
	tecnicRepository.save(tecnic);
	return tecnic;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tecnics/tecnic/{idTecnic}")
    public Tecnic getTecnicById(@PathVariable String idTecnic) {
	return tecnicRepository.findOne(idTecnic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tecnics/{id}")
    public Tecnic updateTecnic(@PathVariable String id, @RequestBody Tecnic tecnic) {
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/tecnics/noms/{nomCognom}")
    public ArrayList<Tecnic> getTecnicBynomCognom(@PathVariable String nomCognom) {
	Iterable<Tecnic> llista = tecnicRepository.findAll();
	ArrayList<Tecnic> tecnics=new ArrayList<>();
	for (Tecnic tec : llista) {
	    if (tec.getNomCognom().contains(nomCognom)) {
		tecnics.add(tec);
	    }
	}
	
	//ArrayList<Tecnic> t= tecnicRepository.findAllBynomCognom(nomCognom);
	return tecnics;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/tecnics/estat/{estat}")
    public ArrayList<Tecnic> getTecnicByEstat(@PathVariable String estat){
	Iterable<Tecnic> llista = tecnicRepository.findAll();
	ArrayList<Tecnic> tecnics=new ArrayList<>();
	for (Tecnic tec : llista) {
	    if (tec.getEstat().equals(estat)) {
		tecnics.add(tec);
	    }
	}
	return tecnics;
    }

}
