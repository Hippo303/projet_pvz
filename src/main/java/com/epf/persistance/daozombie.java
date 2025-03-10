package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class daozombie implements zombiedaoIn{
    private final JdbcTemplate jdbcTemplate;

    public daozombie(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Zombie zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(), zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getMapId());
    }

    @Override
    public Zombie getById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Zombie(rs.getInt("id"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"), rs.getDouble("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
    }

    @Override
    public List<Zombie> getAll() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Zombie(rs.getInt("id"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"), rs.getDouble("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
    }

    @Override
    public void update(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(), zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getMapId(), zombie.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Zombie WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(int mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{mapId}, (rs, rowNum) ->
                new Zombie(rs.getInt("id"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"), rs.getDouble("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
    }

}
