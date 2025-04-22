package com.epf.persistance;

import com.epf.core.model.Plante;

import java.util.List;

public interface plantedaoIn {
        Plante createPlante(Plante plante);
        Plante getPlanteById(Integer id);
        List<Plante> getAllPlantes();
        Plante updatePlante(Plante plante,Integer id);
        void deletePlante(Integer id);
}
