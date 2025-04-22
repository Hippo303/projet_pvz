package testspersistance;

import com.epf.core.model.Zombie;
import com.epf.persistance.ZombieDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class testszombiedao {
    private ZombieDao daoZombie;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        // Création d'une base de données en mémoire pour les tests
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql") // Script pour créer la table Zombie
                .build();

        // Initialisation de JdbcTemplate et du DAO
        jdbcTemplate = new JdbcTemplate(dataSource);
        daoZombie = new ZombieDao(jdbcTemplate);
    }

    @Test
    public void testCreateZombie() {
        // Création d'un zombie
        Zombie zombie = new Zombie(1, "Zombie1", 100, 1.5, 10, 2.0, "zombie.png", 1);
        daoZombie.createZombie(zombie);

        // Récupération du zombie
        Zombie retrieved = daoZombie.getZombieById(1);

        // Vérification des résultats
        assertNotNull(retrieved);
        assertEquals("Zombie1", retrieved.getNom());
    }
}
