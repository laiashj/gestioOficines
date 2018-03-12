package io.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.swagger.model.Lloc;
import io.swagger.model.Projecte;

@Service
public class LlocService {
    private List<Lloc> llocs;

    public LlocService() {
	llocs=new ArrayList<>();
    }

    public List<Lloc> getLlocs() {
        return llocs;
    }

    public void setLlocs(List<Lloc> llocs) {
        this.llocs = llocs;
    }

    public Lloc getLloc(int index) {
	return llocs.get(index);
    }
    public void addLloc(int index, Lloc element) {
	llocs.add(index, element);
    }
    public void updateLloc(int index, Lloc element) {
        llocs.set(index, element);
    }
    
    
}
