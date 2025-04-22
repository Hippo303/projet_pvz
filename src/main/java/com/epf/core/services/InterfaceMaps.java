package com.epf.core.services;

import com.epf.core.model.Map;

import java.util.List;

public interface InterfaceMaps {
    Map createMap(Map map);
    Map updateMap(Map map,int id);
    List<Map> getAllMaps();
    Map getMapById(int id);
    void deleteMap(int id);
}
