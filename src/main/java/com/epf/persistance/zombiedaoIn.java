package com.epf.persistance;

import java.util.List;

//tu récuperes ta db et tu la renvoies
public interface zombiedaoIn {
    void create(Zombie zombie);
    Zombie getById(int id);
    List<Zombie> getAll();
    void update(Zombie zombie);
    void delete(int id);
    List<Zombie> getZombiesByMapId(int mapId);
}