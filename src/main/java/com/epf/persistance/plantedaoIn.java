package com.epf.persistance;

import java.util.List;

public interface plantedaoIn {
        void create(Plante plante);
        Plante getById(int id);
        List<Plante> getAll();
        void update(Plante plante);
        void delete(int id);
}
