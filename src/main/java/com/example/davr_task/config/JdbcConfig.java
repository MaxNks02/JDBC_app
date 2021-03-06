package com.example.davr_task.config;


import org.springframework.context.annotation.Bean;
;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration

public class JdbcConfig {
    @Bean
    public DataSource DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/davr_task");
        dataSource.setUsername("postgres");
        dataSource.setPassword("5771199m");
        return dataSource;
    }
}