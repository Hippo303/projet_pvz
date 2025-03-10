package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class daoplante implements plantedaoIn{
    private final JdbcTemplate jdbcTemplate;

    public daoplante(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(),
                plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet(), plante.getCheminImage());
    }

    @Override
    public Plante getById(int id) {
        String sql = "SELECT * FROM Plante WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Plante(rs.getInt("id"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getDouble("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
    }

    @Override
    public List<Plante> getAll() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Plante(rs.getInt("id"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getDouble("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
    }

    @Override
    public void update(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(),
                plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet(), plante.getCheminImage(), plante.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Plante WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
