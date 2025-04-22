package com.epf.core.services;

import com.epf.core.model.Plante;
import com.epf.persistance.PlanteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteServices implements InterfacePlantes{
    private final PlanteDao planteDao;

    @Autowired
    public PlanteServices(PlanteDao planteDao) {
        this.planteDao = planteDao;
    }

    @Override
    public Plante getPlanteById(Integer id) {
        return planteDao.getPlanteById(id);
    }
    @Override
    public Plante createPlante(Plante plante) {
        return planteDao.createPlante(plante);
    }

    @Override
    public Plante updatePlante(Plante plante, Integer id) {
        return planteDao.updatePlante(plante, id);
    }
    @Override
    public void deletePlante(Integer id) {
        planteDao.deletePlante(id);
    }
    @Override
    public List<Plante> getAllPlantes() {
        return planteDao.getAllPlantes();
    }
}
