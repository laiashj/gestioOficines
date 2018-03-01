package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/findByNom")
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
