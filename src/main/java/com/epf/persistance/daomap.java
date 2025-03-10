package com.epf.persistance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class daomap implements daomapIn {
    private final JdbcTemplate jdbcTemplate;

    public daomap(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Maps map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public Maps getById(int id) {
        String sql = "SELECT * FROM Map WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Maps(rs.getInt("id"), rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"))
        );
    }

    @Override
    public List<Maps> getAll() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Maps(rs.getInt("id"), rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"))
        );
    }

    @Override
    public void update(Maps map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Map WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

