package io.swagger.api;

import java.util.ArrayList;

import io.swagger.model.Projecte;

public interface CustomRepositoryProjecte {

    ArrayList<Projecte> findProjectesByDataBaixa(String alta);

    Projecte findProjecteByNom(String nom);
}
