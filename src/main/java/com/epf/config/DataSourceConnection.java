package com.epf.config;
// la où on fait la connexion avec la base de donnée
// interface de connexion

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataSourceConnection {
    @Bean
    public DataSource DataSourceConnection(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("epf");
        dataSource.setPassword("mot_de_passe");
        dataSource.setURL("jdbc:mysql://localhost:3306/pvz");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("pvz");
        return dataSource;
    }

    @Bean
    public JdbcTemplate JdbcTemplateConnection(DataSource dataSourceval){
        return new JdbcTemplate(dataSourceval);
    }

    public void getConnection(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
