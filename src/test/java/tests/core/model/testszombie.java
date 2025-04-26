package tests.core.model;


import com.epf.core.model.Zombie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testszombie {

    @Test
    public void testgetZombie() {
        Zombie zombie = new Zombie(1, "Zombie classique", 150, 0.5, 10, 1.2, "chemin/zombie.png", 3);

        assertEquals(1, zombie.getId());
        assertEquals("Zombie classique", zombie.getNom());
        assertEquals(150, zombie.getpoint_de_vie());
        assertEquals(0.5, zombie.getattaque_par_seconde());
        assertEquals(10, zombie.getdegat_attaque());
        assertEquals(1.2, zombie.getvitesse_de_deplacement());
        assertEquals("chemin/zombie.png", zombie.getchemin_image());
        assertEquals(3, zombie.getid_map());
    }

    @Test
    public void testsetZombie() {
        Zombie zombie = new Zombie(0, "", 0, 0, 0, 0, "", 0);

        zombie.setId(2);
        zombie.setNom("Zombie cône");
        zombie.setpoint_de_vie(200);
        zombie.setattaque_par_seconde(0.6);
        zombie.setdegat_attaque(15);
        zombie.setvitesse_de_deplacement(1.0);
        zombie.setchemin_image("chemin/cone.png");
        zombie.setid_map(5);

        assertEquals(2, zombie.getId());
        assertEquals("Zombie cône", zombie.getNom());
        assertEquals(200, zombie.getpoint_de_vie());
        assertEquals(0.6, zombie.getattaque_par_seconde());
        assertEquals(15, zombie.getdegat_attaque());
        assertEquals(1.0, zombie.getvitesse_de_deplacement());
        assertEquals("chemin/cone.png", zombie.getchemin_image());
        assertEquals(5, zombie.getid_map());
    }
}
