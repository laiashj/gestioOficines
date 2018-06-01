package io.swagger.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Projecte;

@CrossOrigin
@RestController
public class ProjecteApiController {

    @Autowired
    private ProjecteApi projecteRepository;

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/projectes")
    @ResponseBody
    public Iterable<Projecte> projecte() {
        return projecteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/projectes")
    public Projecte saveProjecte(@RequestBody Projecte projecte) {
        Projecte p = new Projecte(projecte.getNom(), projecte.getDescripcio(), projecte.getColor(),
                projecte.getDataAlta());
        projecteRepository.save(p);
        return p;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/projecte/{idProjecte}")
    public Projecte getProjecteById(@PathVariable String idProjecte) {
        return projecteRepository.findOne(idProjecte);
    }

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
        if (projecte.getDataBaixa() != null) {
            p.setDataBaixa(new Date().toString());
        }
        projecteRepository.save(p);
        return projecte;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/findByNom/{nom}")
    public Projecte findProjecteByName(@PathVariable String nom) {
        Projecte projecte = projecteRepository.findProjecteByNom(nom);
        return projecte;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projectes/alta/{baixa}")
    public List<Projecte> findProjecteAlta(@PathVariable String baixa) {
        Iterable<Projecte> projectesAlta = projecteRepository.findProjectesByDataBaixa(baixa);
        return (List<Projecte>) projectesAlta;
    }

}