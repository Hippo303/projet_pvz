package com.epf.API.DTO;

import com.epf.core.model.Map;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperMap {

    public static DTOMap toDTOMap(Map map) {
        return new DTOMap(
                map.getId(),
                map.getLigne(),
                map.getColonne(),
                map.getCheminImage()
        );
    }

    public static List<DTOMap> toListDTOMap(List<Map> maps) {
        return maps.stream().map(MapperMap::toDTOMap).toList();
    }

    public static Map toMapEntity(DTOMap dtoMap) {
        return new Map(
                dtoMap.getId_map(),
                dtoMap.getLigne(),
                dtoMap.getColonne(),
                dtoMap.getChemin_image()
        );
    }

    public List<Map> toListMapEntity(List<DTOMap> dtoMaps) {
        return dtoMaps.stream().map(MapperMap::toMapEntity).toList();
    }
}
