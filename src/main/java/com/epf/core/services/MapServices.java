package com.epf.core.services;

import com.epf.core.model.Map;
import com.epf.persistance.MapDao;
import com.epf.persistance.ZombieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServices implements InterfaceMaps{
    private final MapDao mapDao;
    private final ZombieDao zombieDao;

    @Autowired
    public MapServices(MapDao mapDao, ZombieDao zombieDao) {
        this.mapDao = mapDao;
        this.zombieDao = zombieDao;
    }

    @Override
    public Map createMap(Map map) {
        return mapDao.createMap(map);
    }

    @Override
    public Map updateMap(Map map, int id) {
        return mapDao.updateMap(map, id);
    }
    @Override
    public Map getMapById(int id) {
        return mapDao.getMapById(id);
    }
    @Override
    public List<Map> getAllMaps() {
        return mapDao.getAllMaps();
    }
    @Override
    public void deleteMap(int id) {
        zombieDao.updateZombiesByMapId(id);
        mapDao.deleteMap(id);
    }

}
