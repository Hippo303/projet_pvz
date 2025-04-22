package com.epf.core.services;

import com.epf.core.model.Zombie;

import java.util.List;

public interface InterfaceZombies {
    Zombie createZombie(Zombie zombie);
    Zombie updateZombie(Zombie zombie,Integer id);
    Zombie getZombieById(Integer id);

    List<Zombie> getAllZombies();
    void deleteZombie(Integer id);
}
