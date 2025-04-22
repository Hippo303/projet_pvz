package com.epf.core.services;

import com.epf.core.model.Plante;
import com.epf.core.model.Zombie;

import java.util.List;

public interface InterfacePlantes {
    Plante createPlante(Plante plante);
    Plante getPlanteById(Integer id);
    List<Plante> getAllPlantes();
    void deletePlante(Integer id);
    Plante updatePlante(Plante plante,Integer id);
}
