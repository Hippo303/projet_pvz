package tests.api.mapper;
import com.epf.API.DTO.MapperZombie;

import com.epf.API.DTO.DTOZombie;
import com.epf.core.model.Zombie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testsmapperzombie {

    @Test
    public void testtoDTOZombie() {
        Zombie zombie = new Zombie(1, "Zombie Normal", 100, 1.5, 25, 0.8, "zombie.png", 2);

        DTOZombie dto = MapperZombie.toDTOZombie(zombie);

        assertEquals(zombie.getId(), dto.getId_zombie());
        assertEquals(zombie.getNom(), dto.getNom());
        assertEquals(zombie.getpoint_de_vie(), dto.getPoint_de_vie());
        assertEquals(zombie.getattaque_par_seconde(), dto.getAttaque_par_seconde());
        assertEquals(zombie.getdegat_attaque(), dto.getDegat_attaque());
        assertEquals(zombie.getvitesse_de_deplacement(), dto.getVitesse_de_deplacement());
        assertEquals(zombie.getchemin_image(), dto.getChemin_image());
        assertEquals(zombie.getid_map(), dto.getId_map());
    }

    @Test
    public void testZtoZombie() {
        DTOZombie dto = new DTOZombie(1, "Zombie Normal", 100, 1.5, 25, 0.8, "zombie.png", 2);

        Zombie zombie = MapperZombie.toZombieEntity(dto);

        assertEquals(dto.getId_zombie(), zombie.getId());
        assertEquals(dto.getNom(), zombie.getNom());
        assertEquals(dto.getPoint_de_vie(), zombie.getpoint_de_vie());
        assertEquals(dto.getAttaque_par_seconde(), zombie.getattaque_par_seconde(), 0.001);
        assertEquals(dto.getDegat_attaque(), zombie.getdegat_attaque());
        assertEquals(dto.getVitesse_de_deplacement(), zombie.getvitesse_de_deplacement(), 0.001);
        assertEquals(dto.getChemin_image(), zombie.getchemin_image());
        assertEquals(dto.getId_map(), zombie.getid_map());
    }
}