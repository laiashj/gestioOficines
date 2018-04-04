package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Lloc;

@RestController
public class LlocApiController {

    @Autowired
    private LlocApi llocRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/llocs")
    public Lloc saveLloc(@RequestBody Lloc lloc) {
        llocRepository.save(lloc);
        return lloc;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/llocs/{idLloc}")
    public Lloc getLlocByidLloc(@PathVariable String idLloc) {
        return llocRepository.findOne(idLloc);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/llocs")
    public Iterable<Lloc> lloc() {
        return llocRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/llocs/{idLloc}")
    public Lloc updateLloc(@PathVariable String idLloc, @RequestBody Lloc lloc) {
        Lloc l = llocRepository.findOne(idLloc);
        if (lloc.getToma() != null) {
            l.setToma(lloc.getToma());
        }
        if (lloc.getDataAlta() != null) {
            l.setDataAlta(lloc.getDataAlta());
        }
        llocRepository.save(l);
        return lloc;
    }
}
