package com.epf.persistance;

import com.epf.core.model.Plante;

import java.util.List;

public interface plantedaoIn {
        Plante createPlante(Plante plante);
        Plante getPlanteById(int id);
        List<Plante> getAllPlantes();
        Plante updatePlante(Plante plante,int id);
        void deletePlante(int id);
}
