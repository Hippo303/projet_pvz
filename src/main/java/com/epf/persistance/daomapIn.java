package com.epf.persistance;

import com.epf.core.model.Map;

import java.util.List;

public interface daomapIn {
    Map createMap(Map map);
    Map getMapById(Integer id);
    List<Map> getAllMaps();
    Map updateMap(Map map,Integer id);
    void deleteMap(Integer id);
}
