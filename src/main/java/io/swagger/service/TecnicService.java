package io.swagger.service;

import java.util.ArrayList;
import java.util.List;
import io.swagger.model.Tecnic;

import org.springframework.stereotype.Service;

@Service
public class TecnicService {

    private List<Tecnic> tecnics;

    public TecnicService() {
	tecnics=new ArrayList<>();
    }

    public List<Tecnic> getTecnics() {
        return tecnics;
    }

    public void setTecnics(List<Tecnic> tecnics) {
        this.tecnics = tecnics;
    }
    
    public void addTecnic(Tecnic t) {
        tecnics.add(t);
    }
    
    public Tecnic getTecnic(int index) {
        return tecnics.get(index);
    }
    public List<Tecnic> getTecnicsByNom(String nom) {
	List<Tecnic> t=getTecnics();
	for(Tecnic tec: t) {
	   if(!tec.getNomCognom().contains(nom)) { //Inicialitzem un arrayList amb tots els tecnics i 
	       t.remove(tec);			//i eliminem els que no contenen aquell nom
	   }
	}
	return t;
    }

    public void updateTecnic(int index, Tecnic tecnic) {
        tecnics.set(index, tecnic);
    }
    
    public List<Tecnic> getTecnicsByStatus(String status) {
	List<Tecnic> t=getTecnics();
	for(Tecnic tec: t) {
	   if(!tec.getEstat().equals(status)) { //Inicialitzem un arrayList amb tots els tecnics i 
	       t.remove(tec);			//i eliminem els que no contenen aquell estatus
	   }
	}
	return t;
    }
    
    
    
}
