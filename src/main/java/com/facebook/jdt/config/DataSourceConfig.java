package com.facebook.jdt.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "myDataSource")
    @Qualifier("myDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myDataSource() throws IllegalArgumentException {
        return DataSourceBuilder.create().build();
    }

}
