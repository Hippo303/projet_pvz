package com.epf.persistance;

import com.epf.core.model.Zombie;

import java.util.List;

//tu récuperes ta db et tu la renvoies
public interface zombiedaoIn {
    Zombie createZombie(Zombie zombie);
    Zombie getZombieById(Integer id);
    List<Zombie> getAllZombies();
    Zombie updateZombie(Zombie zombie,Integer id);
    void deleteZombie(Integer id);
    List<Zombie> getZombiesByMapId(Integer mapId);

    void updateZombiesByMapId(Integer mapId);
}