package com.epf.core.services;

import com.epf.core.model.Plante;
import com.epf.core.model.Zombie;

import java.util.List;

public interface InterfacePlantes {
    Plante createPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlantes();
    void deletePlante(int id);
    Plante updatePlante(Plante plante,int id);
}
