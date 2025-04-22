package com.epf.core.services;

import com.epf.core.model.Zombie;
import com.epf.persistance.ZombieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieServices implements InterfaceZombies{
    private final ZombieDao zombieDao;

    @Autowired
    public ZombieServices(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }
    @Override
    public Zombie createZombie(Zombie zombie) {
        return zombieDao.createZombie(zombie);
    }
    @Override
    public Zombie updateZombie(Zombie zombie,int id) {
        return zombieDao.updateZombie(zombie,id);
    }
    @Override
    public Zombie getZombieById(int id) {
        return zombieDao.getZombieById(id);
    }
    @Override
    public List<Zombie> getAllZombies() {
        return zombieDao.getAllZombies();
    }
    @Override
    public void deleteZombie(int id) {
        zombieDao.deleteZombie(id);
    }

}
