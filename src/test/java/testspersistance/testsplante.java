package testspersistance;

import com.epf.core.model.Zombie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testsplante {
    @Test
    public void testgetters(){
        Zombie z = new Zombie(1, "Zombie1", 100, 1.5, 10, 2.0, "zombie.png", 1);

        assertEquals(z.getId(),1);
        assertEquals("Zombie1", z.getNom());
        assertEquals(100, z.getpoint_de_vie());
        assertEquals(1.5, z.getattaque_par_seconde());
        assertEquals(10, z.getdegat_attaque());
        assertEquals(2.0, z.getvitesse_de_deplacement());
        assertEquals("zombie.png", z.getchemin_image());
        assertEquals(1, z.getid_map());
    }
    public void testsetters(){
        Zombie z = new Zombie(1, "Zombie1", 100, 1.5, 10, 2.0, "zombie.png", 1);
        Zombie z2 = new Zombie(1, "Zombie1", 100, 1.5, 10, 2.0, "zombie.png", 1);
        z2.setId(2);
        z2.setNom("Zombie2");
        z2.setpoint_de_vie(200);
        z2.setattaque_par_seconde(3.0);
        z2.setdegat_attaque(20);
        z2.setvitesse_de_deplacement(4.0);
        z2.setchemin_image("zombie2.png");
        z2.setid_map(2);
        assertEquals(z,z2);
    }
}
