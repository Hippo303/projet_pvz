package tests.api.mapper;

import com.epf.API.DTO.MapperMap;
import com.epf.API.DTO.DTOMap;
import com.epf.core.model.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testsmappermap {

    @Test
    public void testToDTOMap() {
        Map map = new Map(1, 5, 6, "map.png");

        DTOMap dto = MapperMap.toDTOMap(map);

        assertEquals(map.getId(), dto.getId_map());
        assertEquals(map.getLigne(), dto.getLigne());
        assertEquals(map.getColonne(), dto.getColonne());
        assertEquals(map.getCheminImage(), dto.getChemin_image());
    }

    @Test
    public void testToMapEntity() {
        DTOMap dto = new DTOMap(1, 5, 6, "map.png");

        Map map = MapperMap.toMapEntity(dto);

        assertEquals(dto.getId_map(), map.getId());
        assertEquals(dto.getLigne(), map.getLigne());
        assertEquals(dto.getColonne(), map.getColonne());
        assertEquals(dto.getChemin_image(), map.getCheminImage());
    }
}
