package com.epf.persistance;

import com.epf.core.model.Zombie;

import java.util.List;

//tu récuperes ta db et tu la renvoies
public interface zombiedaoIn {
    Zombie createZombie(Zombie zombie);
    Zombie getZombieById(int id);
    List<Zombie> getAllZombies();
    Zombie updateZombie(Zombie zombie,int id);
    void deleteZombie(int id);
    List<Zombie> getZombiesByMapId(int mapId);

    void updateZombiesByMapId(int mapId);
}