package com.epf.persistance.mapper;

import com.epf.core.model.Zombie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZombieRowMapper implements RowMapper<Zombie> {
    @Override
    public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Zombie(rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        );
    }
}