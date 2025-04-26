package tests.api.mapper;

import com.epf.API.DTO.MapperPlante;
import com.epf.API.DTO.DTOPlante;
import com.epf.core.model.Plante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testsmapperplante {

    @Test
    public void testToDTOPlante() {
        Plante plante = new Plante(1, "Peashooter", 100, 1.2, 30, 50, 0.5, "shoot", "peashooter.png");

        DTOPlante dto = MapperPlante.toDTOPlante(plante);

        assertEquals(plante.getId(), dto.getId_plante());
        assertEquals(plante.getNom(), dto.getNom());
        assertEquals(plante.getpoint_de_vie(), dto.getPoint_de_vie());
        assertEquals(plante.getattaque_par_seconde(), dto.getAttaque_par_seconde());
        assertEquals(plante.getdegat_attaque(), dto.getDegat_attaque());
        assertEquals(plante.getCout(), dto.getCout());
        assertEquals(plante.getsoleil_par_seconde(), dto.getSoleil_par_seconde());
        assertEquals(plante.getEffet(), dto.getEffet());
        assertEquals(plante.getCheminImage(), dto.getChemin_image());
    }

    @Test
    public void testToPlanteEntity() {
        DTOPlante dto = new DTOPlante(1, "Peashooter", 100, 1.2, 30, 50, 0.5, "shoot", "peashooter.png");

        Plante plante = MapperPlante.toPlanteEntity(dto);

        assertEquals(dto.getId_plante(), plante.getId());
        assertEquals(dto.getNom(), plante.getNom());
        assertEquals(dto.getPoint_de_vie(), plante.getpoint_de_vie());
        assertEquals(dto.getAttaque_par_seconde(), plante.getattaque_par_seconde());
        assertEquals(dto.getDegat_attaque(), plante.getdegat_attaque());
        assertEquals(dto.getCout(), plante.getCout());
        assertEquals(dto.getSoleil_par_seconde(), plante.getsoleil_par_seconde());
        assertEquals(dto.getEffet(), plante.getEffet());
        assertEquals(dto.getChemin_image(), plante.getCheminImage());
    }
}
