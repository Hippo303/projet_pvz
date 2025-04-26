package tests.core.model;



import com.epf.core.model.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testsmap {

    @Test
    public void testgetmap() {
        Map map = new Map(1, 5, 9, "chemin/image.png");

        assertEquals(1, map.getId());
        assertEquals(5, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("chemin/image.png", map.getCheminImage());
    }

    @Test
    public void testsetmap() {
        Map map = new Map(0, 0, 0, "");

        map.setId(2);
        map.setLigne(3);
        map.setColonne(6);
        map.setCheminImage("new/image.png");

        assertEquals(2, map.getId());
        assertEquals(3, map.getLigne());
        assertEquals(6, map.getColonne());
        assertEquals("new/image.png", map.getCheminImage());
    }
}