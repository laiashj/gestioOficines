package io.swagger.api;

import java.util.ArrayList;

import io.swagger.model.Tecnic;

public interface CustomRepository {
    
    ArrayList<Tecnic> findAllBynomCognom(String nom);
    
    ArrayList<Tecnic> findAllByestat(String estat);
}
