package com.epf.persistance;

import com.epf.persistance.mapper.ZombieRowMapper;
import com.epf.core.model.Zombie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class ZombieDao implements zombiedaoIn{
    private final JdbcTemplate jdbcTemplate;
    public ZombieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Zombie createZombie(Zombie zombie){
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getpoint_de_vie(), zombie.getattaque_par_seconde(), zombie.getdegat_attaque(), zombie.getvitesse_de_deplacement(), zombie.getchemin_image(), zombie.getid_map());
        return zombie;
    }

    @Override
    public Zombie getZombieById(Integer id) {
        try {
            String sql = "SELECT * FROM ZOMBIE WHERE id_zombie = ?";
            Zombie zombie = jdbcTemplate.queryForObject(sql,  new ZombieRowMapper(),id);
            return zombie;
        }catch (org.springframework.dao.EmptyResultDataAccessException e){return null;}

    }

    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public Zombie updateZombie(Zombie zombie,Integer id) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getpoint_de_vie(), zombie.getattaque_par_seconde(), zombie.getdegat_attaque(),
                zombie.getvitesse_de_deplacement(), zombie.getchemin_image(), zombie.getid_map(), id);
        return zombie;
    }

    @Override
    public void deleteZombie(Integer id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(Integer mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{mapId}, new ZombieRowMapper());
    }

    @Override
    public void updateZombiesByMapId(Integer mapId) {
        String sql = "UPDATE Zombie SET id_map = NULL WHERE id_map = ?";
        jdbcTemplate.update(sql, mapId);
    }


}
