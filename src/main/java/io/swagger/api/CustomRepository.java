package io.swagger.api;

import java.util.ArrayList;

import io.swagger.model.Tecnic;

public interface CustomRepository {

    ArrayList<Tecnic> findByNomCognom(String nom);

    ArrayList<Tecnic> findByEstat(String estat);

    ArrayList<Tecnic> findTecnicsByDataBaixa(String alta);

    ArrayList<Tecnic> findTecnicsByProjecte(String nomProjecte);
}
