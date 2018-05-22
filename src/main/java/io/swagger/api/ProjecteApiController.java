package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Projecte;

@RestController
public class ProjecteApiController {

    @Autowired
    private ProjecteApi projecteRepository;

    @CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
    @RequestMapping(method = RequestMethod.GET, value = "/projectes")
    @ResponseBody
    public Iterable<Projecte> projecte() {
        return projecteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/projectes")
    public Projecte saveProjecte(@RequestBody Projecte projecte) {
	projecteRepository.save(projecte);
	return projecte;
    }

    @RequestMapping(method=RequestMethod.GET, value="/projectes/projecte/{idProjecte}")
    public Projecte getProjecteById(@PathVariable String idProjecte) {
	return projecteRepository.findOne(idProjecte);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/projectes/{idProjecte}")
    public Projecte updateProjecte(@PathVariable String idProjecte, @RequestBody Projecte projecte) {
        Projecte p = projecteRepository.findOne(idProjecte);
        if (projecte.getNom() != null) {
            p.setNom(projecte.getNom());
        }
        if (projecte.getDescripcio() != null) {
            p.setDescripcio(projecte.getDescripcio());
        }
        if (projecte.getColor() != null) {
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

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/findByNom/{nom}")
    public List<Projecte> findProjecteByName(@PathVariable String nom) {
        List<Projecte> p = new ArrayList<Projecte>();
        Iterable<Projecte> tots = projecteRepository.findAll();
        for (Projecte projecte : tots) {
            if (projecte.getNom().contains(nom)) {
                p.add(projecte);
            }
        }

        return p;
    }

}