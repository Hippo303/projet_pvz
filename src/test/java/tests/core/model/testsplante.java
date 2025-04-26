package tests.core.model;



import com.epf.core.model.Plante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testsplante {

    @Test
    public void testgetsplante() {
        Plante plante = new Plante(1, "Tournesol", 100, 1.5, 0, 50, 2.0, "génère du soleil", "chemin/tournesol.png");

        assertEquals(1, plante.getId());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getpoint_de_vie());
        assertEquals(1.5, plante.getattaque_par_seconde());
        assertEquals(0, plante.getdegat_attaque());
        assertEquals(50, plante.getCout());
        assertEquals(2.0, plante.getsoleil_par_seconde());
        assertEquals("génère du soleil", plante.getEffet());
        assertEquals("chemin/tournesol.png", plante.getCheminImage());
    }

    @Test
    public void testsetsplante() {
        Plante plante = new Plante(0, "", 0, 0, 0, 0, 0, "", "");

        plante.setId(2);
        plante.setNom("Pisto-pois");
        plante.setpoint_de_vie(120);
        plante.setattaque_par_seconde(0.8);
        plante.setdegat_attaque(20);
        plante.setCout(100);
        plante.setsoleil_par_seconde(0.0);
        plante.setEffet("attaque");
        plante.setCheminImage("chemin/pois.png");

        assertEquals(2, plante.getId());
        assertEquals("Pisto-pois", plante.getNom());
        assertEquals(120, plante.getpoint_de_vie());
        assertEquals(0.8, plante.getattaque_par_seconde());
        assertEquals(20, plante.getdegat_attaque());
        assertEquals(100, plante.getCout());
        assertEquals(0.0, plante.getsoleil_par_seconde());
        assertEquals("attaque", plante.getEffet());
        assertEquals("chemin/pois.png", plante.getCheminImage());
    }
}