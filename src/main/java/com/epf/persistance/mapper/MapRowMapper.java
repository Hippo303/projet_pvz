package com.epf.persistance.mapper;

import com.epf.core.model.Map;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRowMapper implements RowMapper<Map> {
    @Override
    public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Map(
                rs.getInt("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
        );
    }
}
