package com.epf.config;
// la où on fait la connexion avec la base de donnée
// interface de connexion

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.epf")
public class DataSourceConnection {
    @Bean
    public DataSource DataSourceConnection(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");
        dataSource.setUsername("epf");
        dataSource.setPassword("mot_de_passe");
        return dataSource;
    }

    @Bean
    public JdbcTemplate initjdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceConnection());
        return jdbcTemplate;
    }

    public void getConnection(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
