package com.epf.persistance;

import com.epf.persistance.mapper.PlanteRowMapper;
import com.epf.core.model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PlanteDao implements plantedaoIn{
    private final JdbcTemplate jdbcTemplate;

    public PlanteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Plante createPlante(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getpoint_de_vie(), plante.getattaque_par_seconde(), plante.getdegat_attaque(),
                plante.getCout(), plante.getsoleil_par_seconde(), plante.getEffet(), plante.getCheminImage());
        return plante;
    }

    @Override
    public Plante getPlanteById(Integer id) {
        try{
            String sql = "SELECT * FROM Plante WHERE id_plante = ?";
            return jdbcTemplate.queryForObject(sql,new PlanteRowMapper(),id);
        }catch (org.springframework.dao.EmptyResultDataAccessException e){return null;}

    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }
    @Override
    public Plante updatePlante(Plante plante, Integer id) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getpoint_de_vie(), plante.getattaque_par_seconde(), plante.getdegat_attaque(),
                plante.getCout(), plante.getsoleil_par_seconde(), plante.getEffet(), plante.getCheminImage(), id);
        return plante;
    }

    @Override
    public void deletePlante(Integer id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
