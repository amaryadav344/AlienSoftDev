package com.business.core.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@Component
public class DataSourceBean {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource getDataSource() throws IOException {

        return DataSourceBuilder
                .create()
                .url("jdbc:sqlserver://DESKTOP-0IB7S30;databaseName=DEMO")
                .username("DEVUSER")
                .password("DEVPS")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build();
    }
}