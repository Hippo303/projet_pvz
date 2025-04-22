package com.epf.persistance;
import com.epf.persistance.mapper.MapRowMapper;
import com.epf.core.model.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapDao implements daomapIn {
    private final JdbcTemplate jdbcTemplate;

    public MapDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map createMap(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
        return map;
    }

    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new MapRowMapper());
    }

    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public Map updateMap(Map map,int id) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), id);
        return map;
    }

    @Override
    public void deleteMap(int id) {
        String sql = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }
}

